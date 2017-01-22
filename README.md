# BeeLoadingView
一个带有蜂窝效果的Loading
看了很多的loading的样式，发现很多都是各种各样的动画组成的，自己也就想到了一种样式，就是现在的蜂窝loading了，先来上张图看看效果：

![simple.gif](https://github.com/1002326270xc/BeeLoadingView/blob/master/photo/simple.gif)

在这里我分了三类的loading，第一类是第一种情况了，只是改变每一个item的颜色；第二类是第二种情况了，其实这种情况是最简单的，只是旋转外层的父布局而已，所以你看到的是每一个item都在旋转；第三类是第三种情况了，其实是把前面两种情况结合起来而已。

###思路：
这里的view结构就是先整体，然后再到每一个item，外面是一个`FrameLayout`,里面就添加自定义的这种六边形的view，我在这里叫做`BeeView`。

这里画了个操作，指明了这几个item的排版:

![草图.png](http://upload-images.jianshu.io/upload_images/2528336-095d064749cde9c2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

标明的数字就是每一个`BeeView`了，指明的数字就是放的item的顺序。

改变颜色就是不断地改变颜色数组而已，这里数组的长度是7，每次把数组前面的颜色值往后挪一位，最后一位往首位移动。这样就达到颜色值不断地更新。旋转就不用说了吧，这里是围绕外层的`FrameLayout`旋转中心来旋转的。最后一种情况就是前面两种的结合体而已，这里就没什么好说的了。

###代码部分:
  <pre><code>```
    <declare-styleable name="BeeLoadingView">
      <!--这里就是定义上面说的三种情况-->
      <attr name="animate" format="enum">
          <enum name="colorFul" value="1" />
          <enum name="rotate" value="2" />
          <enum name="colorArotate" value="3" />
      </attr>
      <!--每一个item的size大小-->
      <attr name="load_size" format="float" />
    </declare-styleable>
    ```</code></pre>

###更新:
后面还会通过传入图片的形式来生成view，这里还没有更好的思路怎么通过图片来生成view，如果你有更好的建议，可以共同讨论。

###关于我:
- email: a1002326270@163.com
- 简书: http://www.jianshu.com/users/7b186b7247c1/latest_articles

