package metier.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "users", schema = "public", catalog = "marjane")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iduser")
    private int iduser;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "role")
    private String role;
    @Basic
    @Column(name = "idcategory")
    private Integer idcategory;
    @Basic
    @Column(name = "idstore")
    private Integer idstore;
    @OneToMany(mappedBy = "usersByIdstoreadmin")
    private Collection<StoreEntity> storesByIduser;
    @ManyToOne
    @JoinColumn(name = "idcategory", referencedColumnName = "idcategory", insertable = false, updatable = false)
    private CategoryEntity categoryByIdcategory;
    @ManyToOne
    @JoinColumn(name = "idstore", referencedColumnName = "idstore", insertable = false, updatable = false)
    private StoreEntity storeByIdstore;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
    }

    public Integer getIdstore() {
        return idstore;
    }

    public void setIdstore(Integer idstore) {
        this.idstore = idstore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (iduser != that.iduser) return false;
        if (fullname != null ? !fullname.equals(that.fullname) : that.fullname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (idcategory != null ? !idcategory.equals(that.idcategory) : that.idcategory != null) return false;
        if (idstore != null ? !idstore.equals(that.idstore) : that.idstore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iduser;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (idcategory != null ? idcategory.hashCode() : 0);
        result = 31 * result + (idstore != null ? idstore.hashCode() : 0);
        return result;
    }

    public Collection<StoreEntity> getStoresByIduser() {
        return storesByIduser;
    }

    public void setStoresByIduser(Collection<StoreEntity> storesByIduser) {
        this.storesByIduser = storesByIduser;
    }

    public CategoryEntity getCategoryByIdcategory() {
        return categoryByIdcategory;
    }

    public void setCategoryByIdcategory(CategoryEntity categoryByIdcategory) {
        this.categoryByIdcategory = categoryByIdcategory;
    }

    public StoreEntity getStoreByIdstore() {
        return storeByIdstore;
    }

    public void setStoreByIdstore(StoreEntity storeByIdstore) {
        this.storeByIdstore = storeByIdstore;
    }
    public UsersEntity(String fullname, String email, String password, String role, Integer idcategory, Integer idstore) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.idcategory = idcategory;
        this.idstore = idstore;
    }
    public UsersEntity(String fullname, String email, String password, String role,Integer idstore) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.idstore = idstore;
    }
    public UsersEntity(){

    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "iduser=" + iduser +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", idcategory=" + idcategory +
                ", idstore=" + idstore +
                '}';
    }
}
