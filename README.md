CSDN原文：http://blog.csdn.net/SkipperKevin/article/details/55271150
<br/>


**Jsoup网页爬虫关键点：**

* 分析页面元素
* 获取元素特定参数的值（其实图片的url也是同样的）
* 实体类的封装
* 是否存在无效数据，要将其过滤

**其他**（本项目没有）**：**

* 需要前往下一页爬取的，可以根据URL中“/page/1”的页数格式，动态循环爬取


<br/>

<img width="320px" src="http://img.blog.csdn.net/20170216194746685?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvU2tpcHBlcktldmlu/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt="界面1" >&nbsp;&nbsp;<img width="320px" src="http://img.blog.csdn.net/20170216195022377?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvU2tpcHBlcktldmlu/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt="界面2" >

图2 点开题目后超链接到网页，Toolbar里还有分享按钮：

<img width="320px" src="http://img.blog.csdn.net/20170216195201988?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvU2tpcHBlcktldmlu/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt="界面2-1" >&nbsp;&nbsp;<img width="320px" src="http://img.blog.csdn.net/20170216205217188?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvU2tpcHBlcktldmlu/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt="界面3" >

作为个人的面试复习资料是不是方便很多~

<br/>
网页爬虫虽然可以让我们轻松获得来自第三方的数据内容，但是网页的反爬虫手段也陆续出现了，其实多学习一些技术、体会它内在的东西就是对我们有益的，学无止境，大家一起加油吧。

<br/>
注：转载博客请遵循[CC-BY-NC-ND](https://creativecommons.org/licenses/by-nc-nd/3.0/cn/)协议。本文涉及到的内容仅作为学习使用。

本项目用到的资源是： 
①《【剑指Offer学习】【所有面试题汇总】》http://blog.csdn.net/derrantcm/article/details/46887821， 
②《BAT（百度，阿里，腾迅）面试题》http://blog.csdn.net/derrantcm/article/details/46658823#comments。 
非常感谢博主的文章，这里爬取博主大大的文章仅作为学习使用，谢谢！
