collect 收集器
Collector作为collect方法的参数
Collector是一个接口，它是一个可变的汇聚操作，将输入的元素积累到可变的结果容器中，它会在所有元素处理完毕后，将累积的结果转换为一个最终的表示
            （这是一个可选操作），它支持串行和并行两种方式执行
Collectors本身提供了Collector的常见汇聚实现，Collectors本身实际上是一个工厂
为了确保串行与并行操作结果的等价性，Collector函数需要满足两个条件：identity(同一性)与associativity（结合性）
