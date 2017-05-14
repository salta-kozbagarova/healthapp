package kz.salikhanova.healthapp.model;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Role implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -613260988457178122L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="roles_id_seq")
	@SequenceGenerator(name="roles_id_seq", sequenceName="roles_id_seq", allocationSize=1)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
