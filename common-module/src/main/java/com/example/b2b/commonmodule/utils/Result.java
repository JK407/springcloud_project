package com.example.b2b.commonmodule.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> ok(T data) {
        return new Result<>(200, "成功", data);
    }
    public static <T> Result<T> saveSuccess(T data) {
        return new Result<>(201, "添加成功", data);
    }
    public static <T> Result<T> updateSuccess(T data) {
        return new Result<>(202, "更新成功", data);
    }

    public static <T> Result<T> deleteSuccess(T data) {
        return new Result<>(203, "删除成功", data);
    }
    public static <T> Result<T> loginSuccess(T data) {
        return new Result<>(204, "登录成功", data);
    }

    public static <T> Result<T> usernameNull(T data) {
        return new Result<>(501, "用户名不能为空", data);
    }

    public static <T> Result<T> userNull(T data) {
        return new Result<>(502, "用户不存在", data);
    }

    public static <T> Result<T> loginFailed(T data) {
        return new Result<>(503, "登录失败", data);
    }


    public static <T> Result<T> usrNameAndPasswordNotNull(T data) {
        return new Result<>(504, "用户名和密码不能为空", data);
    }

    public static <T> Result<T> UserGetNull(T data) {
        return new Result<>(505, "查询用户列表失败", data);
    }


    public static <T> Result<T> AddError(T data) {
        return new Result<>(506, "用户名已经被注册!", data);
    }


}
