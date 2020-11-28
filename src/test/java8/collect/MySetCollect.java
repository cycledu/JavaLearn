package java8.collect;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @Author : jingtao
 * @Data : 2020/07/27/20:32
 * @Description :
 * @Page or WebSite��
 * @Expected result ��
 */
//�Զ����ռ���
public class MySetCollect<T> implements Collector<T, Set<T>, Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoke");
        return HashSet::new;
    }
    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoke");
        return Set<T>::add;
    }
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoke");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }
    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoke");
//        return v->v;
        return Function.identity();
    }
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoke");
        //��ʶCharacteristics.IDENTITY_FINISH��ʱ����Ϊ�������finisher��ֱ�ӽ���ǿ��ת��
        //�����Characteristics.CONCURRENT,��ʾ�ж���̶߳�ͬһ���ɱ��������в����������ۼ��������ۼӵ�ͬʱ�������������ܻ���ֲ����޸��쳣
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
    }
}
