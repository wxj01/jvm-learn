package com.wxj.jvm;

import com.wxj.bean.HelloJOL;
import com.wxj.bean.NullObject;
import com.wxj.bean.TestNotNullObject;
import com.wxj.bean.TestStringObject;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO Java对象内存布局查看工具-JOL 查看对象头结构
 *
 *
 *
 * @date 2022/2/15 0015 9:14
 */
public class TestObjectHeader {
    boolean a = false;
    /**
     * @description: TODO  Object 对象
     *
     * java.lang.Object object internals:
     * OFF  SZ   TYPE DESCRIPTION               VALUE
     *   0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
     *   8   4        (object header: class)    0xf80001e5
     *  12   4        (object alignment gap)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 9:18
     * @version 1.0
     */
    @Test
    public void test(){
        Object o = new Object();
        String s = ClassLayout.parseInstance(o).toPrintable();
//        1. 输出虚拟机与对象内存布局相关的信息
        System.out.println(VM.current().details());
//        2. 输出对象内存布局信息
        System.out.println(s);
    }



    /**
     * @description: TODO
     *
     * java.lang.Boolean object internals:
     * OFF  SZ      TYPE DESCRIPTION               VALUE
     *   0   8           (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
     *   8   4           (object header: class)    0xf8002085
     *  12   1   boolean Boolean.value             false
     *  13   3           (object alignment gap)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 9:22
     * @version 1.0
     */
    @Test
    public void test2(){
        boolean b = false;
        String s = ClassLayout.parseInstance(b).toPrintable();
        System.out.println(s);
    }

    /**
     * @description: TODO
     *  对象头 12 bytes + 赋值 1 bytes(boolean 占一个字节) + 填充 3 bytes  = 16 bytes
     * java.lang.Boolean object internals:
     *  OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
     *       0     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4           (object header)                           85 20 00 f8 (10000101 00100000 00000000 11111000) (-134209403)
     *      12     1   boolean Boolean.value                             false
     *      13     3           (loss due to the next object alignment)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 10:44
     * @version 1.0
     */
    @Test
    public void test2_2(){
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    /**
     * @description: TODO
     *
     * java.lang.Boolean object internals:
     *  OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
     *       0     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4           (object header)                           85 20 00 f8 (10000101 00100000 00000000 11111000) (-134209403)
     *      12     1   boolean Boolean.value                             false
     *      13     3           (loss due to the next object alignment)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 10:48
     * @version 1.0
     */
    @Test
    public void testBoolean(){
        System.out.println(ClassLayout.parseInstance(new Boolean("a")).toPrintable());
    }

    /**
     * @description: TODO
     * 对象头 12 bytes + 赋值 2 bytes(char 占2个字节) + 填充 2 bytes  = 16 bytes
     * java.lang.Character object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           c6 20 00 f8 (11000110 00100000 00000000 11111000) (-134209338)
     *      12     2   char Character.value                           a
     *      14     2        (loss due to the next object alignment)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 2 bytes external = 2 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 10:53
     * @version 1.0
     */
    @Test
    public void testChar(){
        char c = 'a';
        System.out.println(ClassLayout.parseInstance(c).toPrintable());
    }

    /**
     * @description: TODO
     * 对象头 12 bytes + 赋值 2 bytes(short 占2个字节) + 填充 2 bytes  = 16 bytes
     * java.lang.Short object internals:
     *  OFFSET  SIZE    TYPE DESCRIPTION                               VALUE
     *       0     4         (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4         (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4         (object header)                           20 22 00 f8 (00100000 00100010 00000000 11111000) (-134208992)
     *      12     2   short Short.value                               1
     *      14     2         (loss due to the next object alignment)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 2 bytes external = 2 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 10:54
     * @version 1.0
     */
    @Test
    public void testShort(){
        short s = 1;
        System.out.println(ClassLayout.parseInstance(s).toPrintable());
    }

    /**
     * @description: TODO
     * 对象头 12 bytes + 赋值 4 bytes(int 占4个字节) + 填充 0 bytes  = 16 bytes
     * java.lang.Integer object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           67 22 00 f8 (01100111 00100010 00000000 11111000) (-134208921)
     *      12     4    int Integer.value                             0
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 10:56
     * @version 1.0
     */
    @Test
    public void testInt(){
        int num = 0;
        System.out.println(ClassLayout.parseInstance(num).toPrintable());
    }

    /**
     * @description: TODO
     * 对象头 12 bytes + 赋值 4 bytes(float 占4个字节) + 填充 0 bytes  = 16 bytes
     * java.lang.Float object internals:
     *  OFFSET  SIZE    TYPE DESCRIPTION                               VALUE
     *       0     4         (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4         (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4         (object header)                           4b 21 00 f8 (01001011 00100001 00000000 11111000) (-134209205)
     *      12     4   float Float.value                               0.1
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 10:57
     * @version 1.0
     */
    @Test
    public void testFloat(){
        float f = 0.1f;
        System.out.println(ClassLayout.parseInstance(f).toPrintable());
    }

    /**
     * @description: TODO
     * 对象头 12 bytes + 赋值 8 bytes(long 占8个字节) + 填充 4 bytes  = 24 bytes
     * java.lang.Long object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           ae 22 00 f8 (10101110 00100010 00000000 11111000) (-134208850)
     *      12     4        (alignment/padding gap)
     *      16     8   long Long.value                                1
     * Instance size: 24 bytes
     * Space losses: 4 bytes internal + 0 bytes external = 4 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 10:59
     * @version 1.0
     */
    @Test
    public void testLong(){
        long l = 1L;
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
    }

    /**
     * @description: TODO
     * 对象头 12 bytes + 赋值 8 bytes(double 占8个字节) + 填充 4 bytes  = 24 bytes
     * java.lang.Double object internals:
     *  OFFSET  SIZE     TYPE DESCRIPTION                               VALUE
     *       0     4          (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4          (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4          (object header)                           92 21 00 f8 (10010010 00100001 00000000 11111000) (-134209134)
     *      12     4          (alignment/padding gap)
     *      16     8   double Double.value                              0.1
     * Instance size: 24 bytes
     * Space losses: 4 bytes internal + 0 bytes external = 4 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 11:04
     * @version 1.0
     */
    @Test
    public void testDouble(){
        double d = 0.1;
        System.out.println(ClassLayout.parseInstance(d).toPrintable());
    }

    /**
     * @description: TODO
     * String 类占 24 bytes
     * Integer a = 1 ; java.lang.Integer object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           67 22 00 f8 (01100111 00100010 00000000 11111000) (-134208921)
     *      12     4    int Integer.value                             1
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
     *
     * Integer b = new Integer(1) ; java.lang.Integer object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           67 22 00 f8 (01100111 00100010 00000000 11111000) (-134208921)
     *      12     4    int Integer.value                             1
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 11:08
     * @version 1.0
     */
    @Test
    public void testInteger(){
        Integer a = 1;
        Integer b = new Integer(1);

        System.out.println("Integer a = 1 ; " + ClassLayout.parseInstance(a).toPrintable());
        System.out.println("Integer b = new Integer(1) ; " + ClassLayout.parseInstance(b).toPrintable());
    }

    /**
     * @description: TODO
     *
     * java.lang.String object internals:
     *  OFFSET  SIZE     TYPE DESCRIPTION                               VALUE
     *       0     4          (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4          (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4          (object header)                           da 02 00 f8 (11011010 00000010 00000000 11111000) (-134216998)
     *      12     4   char[] String.value                              []
     *      16     4      int String.hash                               0
     *      20     4          (loss due to the next object alignment)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 16:31
     * @version 1.0
     */
    @Test
    public void testString(){
        String str = "";
        System.out.println(ClassLayout.parseInstance(str).toPrintable());
    }

    /**
     * @description: TODO
     * 对象头 12 bytes + 数组长度 4 bytes  + 6 bytes (6= 2*3  char 占2个字节，数组大小为3)   + 填充 2 bytes  = 24 bytes
     * [C object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           41 00 00 f8 (01000001 00000000 00000000 11111000) (-134217663)
     *      12     4        (object header)                           03 00 00 00 (00000011 00000000 00000000 00000000) (3)
     *      16     6   char [C.<elements>                             N/A
     *      22     2        (loss due to the next object alignment)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 2 bytes external = 2 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 11:09
     * @version 1.0
     */
    @Test
    public void test3(){
        char[] str  = new char[3];
        System.out.println(ClassLayout.parseInstance(str).toPrintable());
    }

    /**
     * @description: TODO
     * 对象头 12 bytes + 数组长度 4 bytes  + 12 bytes (12= 4*3   int 占4个字节，数组大小为3)   + 填充 4 bytes  = 32 bytes
     * [I object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           6d 01 00 f8 (01101101 00000001 00000000 11111000) (-134217363)
     *      12     4        (object header)                           03 00 00 00 (00000011 00000000 00000000 00000000) (3)
     *      16    12    int [I.<elements>                             N/A
     *      28     4        (loss due to the next object alignment)
     * Instance size: 32 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 11:13
     * @version 1.0
     */
    @Test
    public void testIntArray(){
        int[] arr = new int[3];
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
    }

    /**
     * @description: TODO
     * 对象头 12 bytes + 数组长度 4 bytes  + 24 bytes (24= 8*3   long 占8个字节，数组大小为3)   + 填充 0 bytes  = 40 bytes
     * [J object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           a9 01 00 f8 (10101001 00000001 00000000 11111000) (-134217303)
     *      12     4        (object header)                           03 00 00 00 (00000011 00000000 00000000 00000000) (3)
     *      16    24   long [J.<elements>                             N/A
     * Instance size: 40 bytes
     * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 11:22
     * @version 1.0
     */
    @Test
    public void testLongArray(){
        long[] arr = new long[3];
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
    }

    /**
     * @description: TODO
     * 这段理解有问题
     * 这是 对 new String[3] 占用空间 为32,其中 数组长度3 个 String类对象 占 3*24 = 72 ，
     * 故 String[] arr = new String[3]; 一共占用 32 + 72 = 104 bytes
     *
     * 对象头 12 bytes + 数组长度 4 bytes  + 12 bytes (12= 4*3   String 引用 占4个字节，数组大小为3)   + 填充 4 bytes  = 32 bytes
     * [Ljava.lang.String; object internals:
     *  OFFSET  SIZE               TYPE DESCRIPTION                               VALUE
     *       0     4                    (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4                    (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4                    (object header)                           29 37 00 f8 (00101001 00110111 00000000 11111000) (-134203607)
     *      12     4                    (object header)                           03 00 00 00 (00000011 00000000 00000000 00000000) (3)
     *      16    12   java.lang.String String;.<elements>                        N/A
     *      28     4                    (loss due to the next object alignment)
     * Instance size: 32 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 13:21
     * @version 1.0
     */
    @Test
    public void testStringArray(){
        String[] arr = new String[3];
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());

    }

    @Test
    public void testStringObject(){
        TestStringObject testStringObject = new TestStringObject();
        System.out.println(ClassLayout.parseInstance(testStringObject).toPrintable());
        System.out.println(GraphLayout.parseInstance(testStringObject).toPrintable());
        System.out.println(GraphLayout.parseInstance(testStringObject).toFootprint());

    }

    /**
     * @description: TODO
     * CPU 读取内存是一块一块读取的，块的大小可以为 2、4、6、8、16 字节等大小。块大小我们称其为内存访问粒度
     * 因为原字节头是12字节，64位机器下，内存对齐的话就是128位，也就是16字节，所以我们还需要填充4个字节
     * com.wxj.bean.NullObject object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           03 9e 02 f8 (00000011 10011110 00000010 11111000) (-134046205)
     *      12     4        (loss due to the next object alignment)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 10:22
     * @version 1.0
     */
    @Test
    public void testNullObject(){
        System.out.println(ClassLayout.parseInstance(new NullObject()).toPrintable());
    }

    /**
     * @description: TODO
     * 对象头 12 bytes + 数组长度 4 bytes  + 12 bytes (12= 4*3   NullObject 占4个字节，数组大小为3)   + 填充 4 bytes  = 32 bytes
     * [Lcom.wxj.bean.NullObject; object internals:
     *  OFFSET  SIZE                      TYPE DESCRIPTION                               VALUE
     *       0     4                           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4                           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4                           (object header)                           85 9e 02 f8 (10000101 10011110 00000010 11111000) (-134046075)
     *      12     4                           (object header)                           03 00 00 00 (00000011 00000000 00000000 00000000) (3)
     *      16    12   com.wxj.bean.NullObject NullObject;.<elements>                    N/A
     *      28     4                           (loss due to the next object alignment)
     * Instance size: 32 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 15:41
     * @version 1.0
     */
    @Test
    public void testNullObjectArray(){
        NullObject[] arr = new NullObject[3];
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
    }


    /**
     * @description: TODO
     * TestNotNull的类占用空间是24字节，其中头部占用12字节，
     * 变量a是int类型，占用4字节,变量nullObject是引用，占用了4字节，最后填充了4个字节，总共是24个字节，与我们之前的预测一致。
     * 但是，因为我们实例化了NullObject,这个对象一会存在于内存中，所以我们还需要加上这个对象的内存占用16字节，
     * 那总共就是24bytes+16bytes=40bytes。我们图中最后的统计打印结果也是40字节，所以我们的分析正确
     * com.wxj.bean.TestNotNullObject object internals:
     *  OFFSET  SIZE                      TYPE DESCRIPTION                               VALUE
     *       0     4                           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4                           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4                           (object header)                           47 9e 02 f8 (01000111 10011110 00000010 11111000) (-134046137)
     *      12     4                       int TestNotNullObject.a                       0
     *      16     4   com.wxj.bean.NullObject TestNotNullObject.abc                     (object)
     *      20     4                           (loss due to the next object alignment)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     *
     * com.wxj.bean.TestNotNullObject@23a5fd2d object externals:
     *           ADDRESS       SIZE TYPE                           PATH                           VALUE
     *         76d18c4f8         24 com.wxj.bean.TestNotNullObject                                (object)
     *         76d18c510         16 com.wxj.bean.NullObject        .abc                           (object)
     *
     *
     * com.wxj.bean.TestNotNullObject@6a472554d footprint:
     *      COUNT       AVG       SUM   DESCRIPTION
     *          1        16        16   com.wxj.bean.NullObject
     *          1        24        24   com.wxj.bean.TestNotNullObject
     *          2                  40   (total)
     *
     *
     *
     * Process finished with exit code 0
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 15:50
     * @version 1.0
     */
    @Test
    public void testNotNullObject(){
        //打印实例的内存布局
        System.out.println(ClassLayout.parseInstance(new TestNotNullObject()).toPrintable());
        //打印对象的所有相关内存占用
        System.out.println(GraphLayout.parseInstance(new TestNotNullObject()).toPrintable());
        //打印对象的所有内存结果并统计
        System.out.println(GraphLayout.parseInstance(new TestNotNullObject()).toFootprint());
    }


    /**
     * @description: TODO
     *
     * @author wangxinjian
     * @date 2022/2/15 0015 16:02
     * @version 1.0
     */
    @Test
    public void testHelloJOL(){
        HelloJOL helloJOL = new HelloJOL();
        System.out.println(ClassLayout.parseInstance(helloJOL).toPrintable());
        System.out.println(GraphLayout.parseInstance(helloJOL).toPrintable());
        System.out.println(GraphLayout.parseInstance(helloJOL).toFootprint());
    }


}