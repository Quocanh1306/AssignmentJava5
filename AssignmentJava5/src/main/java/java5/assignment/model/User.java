package java5.assignment.model;

import com.oracle.wls.shaded.org.apache.xalan.xsltc.dom.AbsoluteIterator;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma")
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name = "pass_word")
    private String passWord;
    @Column(name = "roler")
    private int role;

    public User() {
    }

    public User(Integer id, String userName, String passWord, int role) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
