

import org.neo4j.spark._
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD
object GraphApp {
	var testMode = false
	val sc = new SparkContext(new SparkConf())

	def main(args: Array[String]){
		val options = args.map {
			arg => arg.dropWhile(_ == '-').split('=') match{
				case Array(opt, v) => (opt -> v)
				case _ => throw new IllegalArgumentException(s"Invalid argument:$arg")
			}
		}
		options.foreach {
			case ("testmode", v) => testMode = v.toBoolean
		}
		uRelativeRatio()		
	}
	def uRelativeRatio(){
		var urGraph: Graph[String, String] = null
		var ubGraph: Graph[String, String] = null
		if(testMode) {
			val u: RDD[(VertexId, (String))] = 
				sc.parallelize(Array((1L, ("10")), (2L, ("10")),
									 (3L, ("20")), (4L, ("10"))
			))
			val r: RDD[Edge[String]] = 
				sc.parallelize(Array(Edge(0L, 1L, "hist"), Edge(0L, 2L, "hist"),
									 Edge(0L, 3L, "hist")
			))
			val b: RDD[Edge[String]] = 
				sc.parallelize(Array(Edge(0L, 4L, "book")
			))
			urGraph = Graph(u, r)
			ubGraph = Graph(u, b)
		}
		else {
			val neo = Neo4j(sc)
			val uHistQuery = "MATCH (n:)"		
			urGraph = neo.rels(uHistQuery).loadGraph
			val uBookQuery = "MATCH (n:)"
			ubGraph = neo.rels(uHistQuery).loadGraph
		}

		val uRelativePair = urGraph.triplets.map(
			triplet => ((triplet.srcAttr+triplet.dstAttr), 
				(triplet.srcAttr, triplet.dstAttr, 1))
		)
		val uR = uRelativePair.reduceByKey(
			(a, b) => (a._1, a._2, a._3+b._3)
		)

		
		val uB: RDD[(String, String)] = ubGraph.triplets.map(
			triplet => (triplet.srcAttr, triplet.dstAttr)
		)
		val ratio = uR.leftOuterJoin(uB).map({
				case (u, ((n, cnt), Some(n))) => (u, (cnt, cnt))
				case (u, ((n, cnt), None)) => (u, (0, cnt))
				case _ => None
			}
		).reduceByKey((a, b) => (a._1 + b._1, a._2 + b._2)).map(
			(exist, total) => exist / total
		)
		ratio.collect.foreach(println(_))
	}
}
