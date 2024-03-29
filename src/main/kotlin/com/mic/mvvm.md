MVVM容易造成的问题如下：
1）需要更多精力定位Bug。由于双向绑定，视图中的异常排查起来会比较麻烦，你需要检查View中的代码，还需要检查Model中的代码。
另外你可能多处复用了Model，一个地方导致的异常可能会扩散到其他地方，定位错误源可能并不会太简单。

2）通用的View需要更好的设计。当一个View要变成通用组件时，该View对应的Model通常不能复用。在整体架构设计不够完善时，
我们很容易创建一些冗余的Model。如果说双向数据流这种“自动管理状态”的特性会给我们造成困扰，除了在编码上规避，
还有其他的解决方案吗？答案是肯定的，这里我们推荐使用谷歌官方的AndroidArchitectureComponents，感兴趣的读者可以自行了解。
