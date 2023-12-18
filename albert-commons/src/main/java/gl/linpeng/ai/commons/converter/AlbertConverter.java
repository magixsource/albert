package gl.linpeng.ai.commons.converter;

/**
 * Albert request and response converter
 */
public interface AlbertConverter<A, B> {

    // 从A类型转为B
    B convert(A a);

    // 从B类型转为A
    A convertBack(B b);


}
