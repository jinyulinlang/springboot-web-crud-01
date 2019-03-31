package com.gao.form;

import java.io.Serializable;

/**
 * @author jinyulinlang
 */
public class LoginForm  implements Serializable {
    private String name;
    private String password;
    private String volidateCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVolidateCode() {
        return volidateCode;
    }

    public void setVolidateCode(String volidateCode) {

        this.volidateCode = volidateCode;
    }

    @Override
    public String toString() {
        return "LoginForm{" + "name='" + name + '\'' + ", password='" + password + '\'' + ", volidateCode='" + volidateCode + '\'' + '}';
    }
}
