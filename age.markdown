---
title: Age
layout: post
---

<body onload="showTime()">
<script language="JavaScript">   
        function showTime(){     
        var thetime=new Date();   //   初始化日期对象 
        var h = thetime.getHours();
        var m = thetime.getMinutes();
        var s = thetime.getSeconds();
        var mm = thetime.getMilliseconds();
        var d = thetime.getDate();
        var mon = thetime.getMonth();
        var y = thetime.getFullYear();
        var z = thetime.getTimezoneOffset();
        var day = (mm/1000+s+m*60+(h+z/60-8)*60*60)/(24*60*60);
        var MyAge = (y-1990)+(mon+1-5)/12+(d+day-11)/30/12;
        //MyAge = Myage.toFixed(2);
        var FixedAge = MyAge.toFixed(11);

        
            document.getElementById( "timeArea").innerText   =  'It is now ' + thetime.toLocaleString(); 
            document.getElementById('age').innerHTML = "I am "+ FixedAge +' years old.'
     
            window.setTimeout( "showTime()",1);   //setTimeout (表达式,延时时间)其中延时时间以豪秒为单位(1000ms=1s)
        } 



</script>




<div id="timeArea" align="center">

</div>

<div id="age" align="center">

</div>


</body>

