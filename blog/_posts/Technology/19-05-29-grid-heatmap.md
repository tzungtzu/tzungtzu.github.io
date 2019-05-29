---
layout: post
title: 高德地图网格图层热力图制作
categories: 
- Technology
tags:
- js
- map
- 地理大数据

---

高德地图JS API V1.3的热力图实现，基于第三方库heatmap.js（官网地址：http://www.patrick-wied.at/static/heatmapjs/）。


demo 如下

[蜂窝热力图 - 通过事件获取数据](https://tzungtzu.github.io/demo/js_heatmap/loca.html)

##使用方法：

- 先后引入高德地图api和heatmap-amap.js

```html
<script src="http://webapi.amap.com/maps?v=1.4.14&key=e3c23244fa7d4a21a4e31c2db69ee6d6"></script>
<script src="http://webapi.amap.com/loca?v=1.3.0&key=e3c23244fa7d4a21a4e31c2db69ee6d6"></script>
<script src="http://a.amap.com/Loca/static/dist/jquery.min.js"></script>
```

<!--more-->

- 初始化高德热力图对象

```javascript
    /*
    * map：地图对象
    * opts：可选参数，其中
    *   radius：热力图每个点的半径，用于grid, hexagon
    *   opacity：热力图的透明度，取值范围0-1

    */
const map = new AMap.Map('container');

const layer = new Loca.GridLayer({
    map: map
});

layer.setData(heatdata, {
    lnglat: 'lnglat'
});

layer.setOptions({
    style: {
        // 网格热力半径，单位：米
        radius: 300,
        opacity: [0.1, 0.8],
        // 热力聚合模式，count 为点数量加和
        mode: 'count',
        // 颜色范围
        color: [
           '#f0f9e8',
           '#bae4bc',
           '#7bccc4',
           '#43a2ca',
           '#0868ac',
        ]
    }
});

// 渲染
layer.render();
```

- 设置数据。
或者直接连接外部csv/tsv

```javascript
   var obj = {
        max: 90, //权重最大值
        //lng为经度值，lat为纬度值，count为权重
        data: [
            {lng:114.169922, lat:30.606004, count: 80},
            {lng:114.322357, lat:30.640275, count: 60},
            {lng:114.33197, lat:30.556348, count: 90},
            ...
        ]
    };

    //调用setDataSet()方法即可显示。
    heatmap.setDataSet(obj);


```

##API说明

heatmap-amap.js还暴露了一些方法。

- setDataSet，见使用方法
- addDataPoint(lng, lat, count)，添加一组数据显示在热力图中。
- toggle()，切换热力图的显示与隐藏。
- clear()，清除热力图。


##另外讲一些基本的教程

1. 创建地图实例
通过 AMap.Map 创建底图：
```javascript
const amap = new AMap.Map('container');

```

```javascript
		var map = new AMap.Map('container', {
			mapStyle: 'amap://styles/twilight',
			zoom: 12,
			center: [116.43, 39.92], 
			zooms: [4, 12]
		});

// 工具条控件

		map.plugin(["AMap.ToolBar"],function () {
				map.addControl(new AMap.ToolBar()); 

//marker
		var m1 = new AMap.Marker({
			map: map,
			draggable:false,
			position: new AMap.LngLat(116.459579, 39.911798)
			});

//rectangle
			function drawRectangle(){
				var southWest = new AMap.LngLat(116.459579,39.911798)
				var northEast = new AMap.LngLat(116.459579+0.063,39.911798+0.048)
				
				var bounds = new AMap.Bounds(southWest, northEast)

				var rectangle = new AMap.Rectangle({
					bounds: bounds,
					strokeColor:'red',
					strokeWeight: 2,
					strokeOpacity:0.5,
//					strokeDasharray: [30,10],
					fillColor:'blue',
					fillOpacity:0.5,
					cursor:'pointer',
//					zIndex:50
				})
				rectangle.setMap(map)
				
				var infowindow=new AMap.InfoWindow({
					content:"<h3>rectangle</h3><p>p1</p><p>p2</p>",
					closeWhenClickMap:true
				});
				
				rectangle.on("mouseover",function (e) {
					infowindow.open(map,bounds.getCenter());
				}).on("mouseout",function () {
					infowindow.close();
				});
				
			}
			
			drawRectangle()

```

通过ne 和 sw 两个点画矩形，另外建立鼠标监听事件