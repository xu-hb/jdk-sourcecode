/*
 * Copyright (c) 1995, 2004, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

/**
 * <code>Cloneable</code> 接口用于标识 {@link java.lang.Object#clone()}是合法的
 *
 * 如果类没有实现 <code>Cloneable</code> 接口，调用改对象的<code>clone</code>方法将抛出
 * <code>CloneNotSupportedException</code>
 *
 * 通常，实现了该接口的类应该 用public覆盖<tt>Object.clone</tt>(默认protected)
 *
 * 注意，接口不包含<tt>clone</tt>方法，因此 仅实现该接口不可能克隆对象，
 * 即使 通过反射调用 也不能保证会成功
 *
 * @author  unascribed
 * @see     java.lang.CloneNotSupportedException
 * @see     java.lang.Object#clone()
 * @since   JDK1.0
 */
public interface Cloneable {
}
