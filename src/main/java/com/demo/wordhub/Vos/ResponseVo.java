package com.demo.wordhub.Vos;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 全局Response类
 *
 * @author OuOu
 * @version 1.0
 */
@Getter
public class ResponseVo/* implements Serializable*/{
    /**
    * 状态码
     * 建议使用HTTPStatus获取状态码
     */
    private final int value;
    /**
     * 状态信息
     */
    private final String msg;
    /**
     * 返回的对象
     */
    private final Object data;

    // 手动设置返回vo
    public ResponseVo(int value, String msg, Object data) {
        this.value = value;
        this.msg = msg;
        this.data = data;
    }

    public ResponseVo(int value, String msg) {
        this.value = value;
        this.msg = msg;
        this.data = null;
    }

    // 默认返回成功状态码，数据对象
    public ResponseVo(Object data) {
        this.value = HttpStatus.OK.value();
        this.msg = HttpStatus.OK.getReasonPhrase();
        this.data = data;
    }

    // 只返回状态码
    public ResponseVo(HttpStatus status) {
        this.value = status.value();
        this.msg = status.getReasonPhrase();
        this.data = null;
    }
}
