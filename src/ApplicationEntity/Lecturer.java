/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationEntity;

/**
 *
 * @author hp
 */
public class Lecturer {
    private String lecture_id;
    private String fn;
    private String ln;

    public Lecturer(String lecture_id, String fn, String ln) {
        this.lecture_id = lecture_id;
        this.fn = fn;
        this.ln = ln;
    }

    public Lecturer() {
    }
    
    

    public String getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(String lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }
    
    
    
}

