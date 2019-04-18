苹果公司本周在开源项目托管平台 GitHub 上分享了 Turi Create 的框架。苹果表示，这一框架应该会让开发者更容易构建机器学习模型。正如苹果所描述的，Turi Create 是为那些在机器学习方面不一定是专家的人设计的。根据苹果的说法，Turi Create 简化了定制机器学习模型的开发。你不需要成为一个机器学习专家，也可以在你的应用中添加建议、对象检测、图像分类、图像相似性或活动分类。

Turi Create 的设计意图是简单易用，具有视觉界面，灵活和快速。此外，它还可以部署在 iOS、macOS、watchOS 和 tvOS 上面。


秃驴
自带SFrame，可以直接从sql database提数据，pandas或成最大输家！


SFrame 基本操作

1. 生成 SFrame

        from turicreate import SFrame      
        sf = SFrame({'id':[1,2,3],'val':['A','B','C'],'val2':['A','B','C']})
        #ids = tc.SArray([1,2,3])

2. 列操作
        
        sf['id'] #选中列
        del sf["val2"] # 删除列
        print(sf.column_names()) # 列举列名   type:sf.column_types
        sf.add_column(sa, 'species') #添加列

3. 行操作

        sf[1]
        sf[1:]   
        sf = sf.append(sf2) #行联合 
        sf[(sf['id'] >= 1)

切片一样，但是sf[1]代表选中第二行，返回的是dict格式！奇特！

行联合等同于 pd.contat


4. 新增 index
5. 


SF 数据运行

        sf.groupby
        sf.stack
        # 格式转换
        SFrame.to_dataframe()   Convert this SFrame to pandas.DataFrame.
        SFrame.to_numpy()   Converts this SFrame to a numpy array
        SFrame.to_sql(conn, table_name[, ...])  Convert an SFrame to a single table in a SQL database.

### References:
1. [python︱apple开源机器学习框架turicreate中的SFrame——新形态pd.DataFrame - CSDN博客](http://blog.csdn.net/sinat_26917383/article/details/78805714)
2. 