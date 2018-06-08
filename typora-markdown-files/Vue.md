###Vue

####[滚动条]()

* 当一个div比table大小要小时，滚动条就会自动生成显示出来
* 自动获取当前比较小的div的scrollTop值


```
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<div style="width:200px;height:200px;background-color:#999999;overflow:auto;" id="out">
			<div style="width:100px;height:300px;background-color:#FFFF00;" id="inner">
				这些文字显示在内层元素中。
			</div>
		</div>
		<p>scrollTop值是：<span id="show"></span></p>

		<script type="text/javascript">
			var out = document.getElementById("out");
			var show_ele = document.getElementById("show");
			out.onscroll = function(){
				show_ele.innerHTML = out.scrollTop;
			};
			//使用匿名函数或是声明函数，若是声明函数需要这样调用
			/**
			* out.onscroll = readVal;
			* function readVal(){
            *    show_ele.innerHTML = out.scrollTop;
			* }
			*/
			//注册onscroll事件处理函数。当拖动滚动条时，会产生onscroll事件
			//onscroll事件的处理函数
			//页面加载完成后，执行一次此函数。显示最初的scrollTop值，此时的值为0
		</script>
	</body>
</html>
```

* 通过手动来设置div的scrollTop的值

  ```
  <!DOCTYPE html>
  <html>

  	<head>
  		<meta charset="UTF-8">
  		<title></title>
  	</head>

  	<body>
  		<div style="width:200px;height:200px;background-color:#999999;overflow:auto;" id="out">
  			<div style="width:100px;height:300px;background-color:#FFFF00;" id="inner">
  				这些文字显示在内层元素中。
  			</div>
  		</div>

  		<p>scrollTop值是：<span id="show_scrollTop"></span></p>

  		<p><button type="button" onclick="out.scrollTop=50;">把scrollTop设为50</button>
  			<button type="button" onclick="out.scrollTop=500;">把scrollTop设为500</button>
  		</p>

  		<p>inp_scrollTop:<input type="text" id="inp_scrollTop" value="" />
  			<button type="button" onclick="set_scrollTop()" name="setVal">确定</button>
  		</p>

  		<script type="text/javascript">
  			var out = document.getElementById("out");
  			var show_scrollTop = document.getElementById("show_scrollTop");
  			//注册onscroll事件处理函数。当拖动滚动条时，会产生onscroll事件
  			out.onscroll = function(){
  				show_scrollTop.innerHTML = out.scrollTop;
  			}
  			//页面加载完成后，执行一次此函数。显示最初的scrollTop值，此时的值为0
  			//read_out_scrollTop();
  			
  			//通过js语句来设置scrollTop的值,本条语句会触发onscroll事件，使得"read_out_scrollTop"函数执行一次。
  			//div_out.scrollTop = 10;

  			function set_scrollTop() {
  				if( "" != document.getElementById("inp_scrollTop").value )
  					out.scrollTop = document.getElementById("inp_scrollTop").value;
  				else alert("请输入一个数值");
  			}
  		</script>
  	</body>

  </html>

  ```
####[vue中的组件理解]()

  1.组件其实就是自己定义了一个任何名称的元素标签

  如下面的例子

  ```
<div id="div">
  			<ol>
  				<app  v-bind:a="item" v-for="item in categoryList">{{item.text}}</app>
  				<app  v-bind:a="item" v-for="item in goods">{{item.name}}</app>
  			</ol>
  		</div>
  		<script>
  			Vue.component('app', {
  				props: ['a'],
  				template: '<li>{{a.text}}{{a.name}}</li>'
  			});
  			var vue = new Vue({
  				el: '#div',
  				data: {
  					categoryList: [{
  						id: 0,
  						text: 'aaa'
  					}, {
  						id: 1,
  						text: 'bbb'
  					}, {
  						id: 2,
  						text: 'ccc'
  					}],
  					goods:[{name:'tom',age:'21'}]
  				}
  			});
  		</script>
  ```

####[vue中的$]()

    1. 有$前缀的，一般表示Vue的实例属性与方法，以便与用户定义的属性区分开来

    2. 例如

```
     var data = { a : 1};
     var vm = new Vue({
       el: '#example',
       data: data
     });
     vm.$data === data; // => true
     vm.$el === document.getElementById('example');
     // $watch 是一个实例方法
     vm.$watch('a',function(newValue,oldValue){
       //这个回调函数将在 'vm.a' 改变后调用
     });

```

####[v-on与v-bind]()

     。v-on是监听指令

     。v-bind是绑定指令

     v-bind是将该元素的属性与Vue进行绑定

     v-on也是同理

     v-on在后续的实践中，都以缩写形式出现：@

     v-bind以 : 出现

####[计算属性与方法的理解]()

     。说白了就是computed与methods中的方法的区别

```
     <body>
     		<div id="div">
     			<span id="p">
     				<p>原始信息: {{Msg}}</p>
     				<p>反转信息: {{reMsg}}</p>
     			</span>
     		</div>
     		<script>
     			var vm = new Vue({
     				el:'#div',
     				data:{
     					Msg:'我是谁'
     				},
     				computed:{
     					//计算属性不需要去监听某一个对象，而是相当于计算某一个变量的值
     					//watch等监听属性就需要去监听一个对象
     					//这个是计算属性的getter方法
     					reMsg: function(){
     						var _self = this;
     						return _self.Msg.split('').reverse().join('');
     					}
     				}
     			});
     		</script>
     	</body>
```

     通过这段代码我们不难看出，这里的 reMsg 也可以写成一个methods，照样可以实现同样的效果；没错，理论上也是可以的，但是这涉及到一个深层次的问题：就是computed与methods的原理剖析，computed中的计算属性是一种依赖关系，依赖于此处的 Msg ，换言之，如果Msg 不发生改变，那么不论访问多少次 reMsg ，都不会再去重新计算这个结果，而是直接调用缓存来返回结果；但是methods不一样，它是每次调用都要去重新处理函数去得到结果，然后再去渲染，这无疑会大大的增加程序的负担

#### [计算属性与侦听器]()

```
<body>
	<div id="div">
		{{fullName}}
	</div>
	<script>
		var vue = new Vue({
			el:'#div',
			data:{
				firstName:'Foo',
				lastName:'Bar',
				//fullName:'Foo Bar'
			},
			computed:{
				//也可以不使用watch侦听器,使用计算属性
				fullName:{
				//你可以对fullName添加set方法，默认只有get方法
					get: function(){
						return this.firstName + '   ' + this.lastName;
					},
					set: function(val){
						var fu = val.split('');
						this.firstName = fu[0];
						this.lastName = fu[fu.length-1];
					}
				}
			},
			watch:{
//				firstName: function(val){
//					this.fullName = val + '  ' + this.lastName;
//				},
//				lastName: function(val){
//					this.fullName = val + '  ' + this.firstName;
//				}
			},
			methods:{}
		});
	</script>
</body>
```

虽然计算属性在大多数情况下更合适，但是有时候也需要一个自定义的侦听器，这就是为什么Vue通过watch选项提供了一个更通用的方法，来响应数据的变化，当需要在数据变化时执行异步或开销较大的操作时，这个方式是最有用的 

#### [class与style的绑定]()

```
<div class="static"
     v-bind:class="{ active: isActive, 'text-danger': 		hasError }">
</div>

data: {
  isActive: true,
  hasError: false
}
```

用在自定义组件上时，这个元素已经存在的class不会被覆盖

```
Vue.component('my-component', {
  template: '<p class="foo bar">Hi</p>'
})
然后在使用的时候，添加一些class
<my-component class="baz boo"></my-component>
最终渲染效果为
<p class="foo bar baz boo">Hi</p>
```

对于带数据绑定的也一样适用

```
<my-component v-bind:class="{ active: isActive }"></my-component>
当 isActive 为 truthy时，HTML 将被渲染成为：
<p class="foo bar active">Hi</p>
```

#### [v-if]()

v-if是一种条件渲染

你也可以使用 v-else 指令来表示 v-if 的 ‘else’ 块

但是必须要注意的一点是：v-else所在的元素必须紧跟在 v-if 或者 v-else-if 的元素的后面，否则它将不会被识别

请看这个例子

```
<body>
		<div id="div">
			<template v-if="loginType === 'userName'">
				<label>userName</label>
				<input placeholder="Please enter your userName. " />
			</template>
			<template v-else>
				<label>Email</label>
				<input placeholder="Please enter your email. " />
			</template>
		</div>
		<script>
			var vue = new Vue({
				el:'#div',
				data:{
					loginType: 'userName'
				}
			});
			/*
			 在上面的这段代码中，切换loginType，将不会清除用户已经输入的内容，因为两个模板使用了相同的元素，<input>不会被替换掉
			 ，仅仅是替换了它的placeholder
			 * */
		</script>
	</body>
```

![key](C:\Users\shiro\Pictures\Saved Pictures\udan\key.PNG)

切换loginType之后：

![key2](C:\Users\shiro\Pictures\Saved Pictures\udan\key2.PNG)

但是，这样也不总是符合实际需求，所以Vue为我们提供了一种方式来表达“这两个元素是完全独立的，不要复用他们了”，只需要添加一个具有唯一值的  key  属性即可，请看下节

#### [key]()

```
<template v-if="loginType === 'username'">
  <label>Username</label>
  <input placeholder="Enter your username" key="username-input">
</template>
<template v-else>
  <label>Email</label>
  <input placeholder="Enter your email address" key="email-input">
</template>
```

现在每次切换时，输入框都将被重新渲染，但是 <label> 元素仍然会被高效的复用，因为它们没有添加 key 属性

#### [v-show]()

v-show也是用于根据条件展开元素的指令，用法大致一样，

```
<h1 v-show="ok">Hello!</h1>
```

不同的是带有 v-show 的元素始终会被渲染并保留在DOM中，v-show只是简单地切换元素的 css 属性 display

【注意，v-show不支持<template>元素，也不支持 v-else】

#### [v-for遍历数组]()

在 v-for 块中，还支持一个可选的第二个参数为当前项的索引

```
<div id='app'>
	<ul>
		<li v-for="(todo,index) in todos">    		{{todo.text}}-{{index}}</li>
	</ul>
</div>	
<script>
var app = new Vue({
				el:'#app',
				data:{
					todos:[
						{text:'a'},
						{text:'b'},
						{text:'c'}
					]
				}
			});
</script>
```

运行结果如下：

![捕获](C:\Users\shiro\Pictures\Saved Pictures\udan\捕获.PNG)

#### [v-for对对象的遍历]()

你也可以用 v-for 来迭代一个对象

```
<ul id='v-for-object' class='demo'>
	<li v-for='value in object'>
		{{value}}
	</li>
</ul>

new Vue({
  el:'#v-for-object',
  data:{
    object:{
      firstName:'John',
      llastName:'Doe',
      age:30
    }
  }
})
```

显示结果：

![捕获](C:\Users\shiro\Pictures\Saved Pictures\udan\捕获.PNG)

如果你也想要把object对象的键也打印出来，可以这么做

```
<div v-for='{value,key} in object'>
	{{key}}:{{value}}
</div>
```

显示如下：

![捕获](C:\Users\shiro\Pictures\Saved Pictures\udan\捕获.PNG)

还可以提供第三个参数为索引：

```
<div v-for="(value, key, index) in object">
  {{ index }}. {{ key }}: {{ value }}
</div>
```

![捕获](C:\Users\shiro\Pictures\Saved Pictures\udan\捕获.PNG)

【注意，如果遍历的是对象，那一定是以键值对来存储的，所以可以通过key和value来取值；但是不管是对象还是数组都会有index属性】

#### [v-on监听事件]()

```
<body>
<div id="div">
	<button v-on:click="counter+=1">button</button>
		<p>you have clicked the button {{counter}} times.</p>
</div>
<script>
	var vue = new Vue({
		el:'#div',
		data:{
			counter:0
		}
	});
</script>
</body>
```

当然这里也可以用methods去绑定这个事件，实现监听，但是换成computed以后就不行，原理不同，computed有依赖关系而更新

【注意，v-on:click="counter+=1"，这里面的counter一直是一个类似变量的东东，因此可以在这里直接对这个变量符号进行操作，并不是传统的被双引号等括起来就是字符串了，谨记】

#### [访问原始的DOM事件]()

有时候也需要在内联语句处理器中访问原始的DOM事件，可以用特殊变量 $event 把它传入：

```
<button v-on:click="warn('Form cannot be submitted yet.', $event)">
  Submit
</button>

// ...
methods: {
  warn: function (message, event) {
    // 现在我们可以访问原生事件对象
    if (event) event.preventDefault()
    alert(message)
  }
}
```

$event 这个知识点很陌生，需要记忆

#### [事件修饰符]()

就像上一步中的 event.preventDefault() 或 event.stopPropagation()，是非常常见的需求。尽管我们可以在方法中轻松实现这点，但更好的方式是 ：方法只有纯粹的数据逻辑，而不是去处理DOM事件细节

为了解决这个问题，Vue.js 为 v-on 提供了事件修饰符，修饰符是由点开头的指令后缀来表示的

```
<!-- 阻止单击事件继续传播 -->
<a v-on:click.stop="doThis"></a>

<!-- 提交事件不再重载页面 -->
<form v-on:submit.prevent="onSubmit"></form>

<!-- 修饰符可以串联 -->
<a v-on:click.stop.prevent="doThat"></a>

<!-- 只有修饰符 -->
<form v-on:submit.prevent></form>

<!-- 添加事件监听器时使用事件捕获模式 -->
<!-- 即元素自身触发的事件先在此处处理，然后才交由内部元素进行处理 -->
<div v-on:click.capture="doThis">...</div>

<!-- 只当在 event.target 是当前元素自身时触发处理函数 -->
<!-- 即事件不是从内部元素触发的 -->
<div v-on:click.self="doThat">...</div>
```

使用修饰符时，顺序很重要；相应的代码会以同样的顺序产生，因此，用 v-on:click.prevent.self 会阻止所有的点击，而 v-on:click.self.prevent 只会阻止对元素自身的点击

#### [表单输入绑定]()

##### 基础用法

你可以使用 v-model 指令在表单<input>及<textarea>元素上创建数据的双向绑定

v-model 会忽略所有表单元素的value、checked、selected特性的初始值，而总是将Vue实例的数据作为数据来源，你只能通过javaScript在组件的 data 选项中声明初始值

##### 多行文本

```
<span>Multiline message is:</span>
<p style="white-space: pre-line;">{{ message }}</p>
<br>
<textarea v-model="message" placeholder="add multiple lines"></textarea>
```

<textarea>元素中，v-model的使用也是一样的；但是直接在<textarea></textarea>标签中间插值是不会生效的，这点不一样，应该使用v-model来代替