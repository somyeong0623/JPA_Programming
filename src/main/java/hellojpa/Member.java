package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; // javax.persistence를 선택해야함.
import javax.persistence.Table;

@Entity//@Table(name = "USER") //데이터베이스에 테이블 이름이 MEMBER가 아니라 USER이면 이렇게 바꿔주면 됨.
public class Member {
    @Id
    private Long id;

//    @Column(name = "") 컬럼이름 다르면 이렇게 설정해주면 됨.
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
