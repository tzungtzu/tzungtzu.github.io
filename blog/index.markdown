---
layout: default

---

<div>
  <ul class="listing">

  <article class="content" >
    {% for post in site.posts limit: 3 %}
    <section class="title">
      <h2><a href="{{ post.url }}">{{ post.title }}</a></h2>
    </section>
    <section class="meta">
    <span class="time">
      <time datetime="{{ post.date | date:"%Y-%m-%d" }}">{{ post.date | date:"%Y-%m-%d" }}</time>
    </span>
    
    
    {% if post.tags %}
    <span class="tags">
      {% for tag in post.tags %}
      <a href="/tags.html#{{ tag }}" title="{{ tag }}">#{{ tag }}</a>
      {% endfor %}
    </span>
    {% endif %}
    </section>
    <section class="post">
		        <div class="content">
					 {{ post.content | split:'<!--more-->' | first }}
<!-- 		        </div> -->
		    	<!-- 标签 -->
       <p class="preadmore" style="border-bottom: 1px solid #EBEEEF"><a href="{{ BASE_PATH }}{{ post.url }}" alt="Read More" class="readmore"><span>&#10149;</span>阅读全文</a></p>
 <!-- readmore按钮 -->
<br />
        	
<!--     </section> -->
<!--     </article> -->
  {% endfor %}
<!--   </ul> -->
  <div class="center">
  <a href="/archive.html" class="circle-wrapper">
  <div class="circle">&nbsp;</div>
  <div class="circle">&nbsp;</div>
  <div class="circle">&nbsp;</div>
  </a>
  </div>
<!-- </div> -->

