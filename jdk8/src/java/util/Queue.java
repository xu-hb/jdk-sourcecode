/*
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

/*
 *
 *
 *
 *
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util;

/**
 * 排序方式：
 * - FIFO
 * - Prior
 * - LIFO
 * 无论什么排序方式，都通过{@link #remove() } or {@link #poll()}删除元素
 *
 * 队列提供额外的插入，提取和检查操作。 这些方法中的每一种都有两种形式
 * - 如果操作失败，则抛出一个异常
 * - 返回一个特殊值（ null或false ，具体取决于操作）
 *
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 * <caption>Summary of Queue methods</caption>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Returns special value</em></td>
 *  </tr>
 *  <tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link Queue#add add(e)}</td>
 *    <td>{@link Queue#offer offer(e)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link Queue#remove remove()}</td>
 *    <td>{@link Queue#poll poll()}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link Queue#element element()}</td>
 *    <td>{@link Queue#peek peek()}</td>
 *  </tr>
 * </table>
 *
 * 例如：{@link #offer offer}插入一个元素返回false，和{@link java.util.Collection#add Collection.add}
 * 抛出异常不同，offer是用于故障是正常情况下使用，而不是异常发生
 *
 * {@link #remove()} and {@link #poll()}也是类似，当queue为空时，
 * remove抛出异常，poll返回null
 *
 * 阻塞队列接口： {@link java.util.concurrent.BlockingQueue}
 *
 * {@code Queue}通常不允许插入null，尽管一些实现，如{@link LinkedList}没有禁止插入null
 * 即使允许这么做，但null也不应该被插入到queue中，因为null也被用于特殊返回结果(poll)
 *
 * <p>{@code Queue} implementations generally do not define
 * element-based versions of methods {@code equals} and
 * {@code hashCode} but instead inherit the identity based versions
 * from class {@code Object}, because element-based equality is not
 * always well-defined for queues with the same elements but different
 * ordering properties.
 *
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @see java.util.Collection
 * @see LinkedList
 * @see PriorityQueue
 * @see java.util.concurrent.LinkedBlockingQueue
 * @see java.util.concurrent.BlockingQueue
 * @see java.util.concurrent.ArrayBlockingQueue
 * @see java.util.concurrent.LinkedBlockingQueue
 * @see java.util.concurrent.PriorityBlockingQueue
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this collection
 */
public interface Queue<E> extends Collection<E> {
    /**
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    boolean add(E e);

    /**
     * 添加元素
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     *         {@code false}
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    boolean offer(E e);

    /**
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E remove();

    /**
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E poll();

    /**
     * 返回头元素，和{@link #peek peek}区别在于抛出异常当队列为空时抛出异常
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E element();

    /**
     * 返回头元素，为空时返回null
     */
    E peek();
}
