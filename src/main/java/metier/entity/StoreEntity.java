package metier.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "store", schema = "public", catalog = "marjane")
public class StoreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idstore")
    private int idstore;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "idstoreadmin")
    private int idstoreadmin;
    @OneToMany(mappedBy = "storeByIdstore")
    private Collection<PromoEntity> promosByIdstore;
    @ManyToOne
    @JoinColumn(name = "idstoreadmin", referencedColumnName = "iduser", nullable = false, insertable = false, updatable = false)
    private UsersEntity usersByIdstoreadmin;
    @OneToMany(mappedBy = "storeByIdstore")
    private Collection<UsersEntity> usersByIdstore;

    public int getIdstore() {
        return idstore;
    }

    public void setIdstore(int idstore) {
        this.idstore = idstore;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getIdstoreadmin() {
        return idstoreadmin;
    }

    public void setIdstoreadmin(int idstoreadmin) {
        this.idstoreadmin = idstoreadmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreEntity that = (StoreEntity) o;

        if (idstore != that.idstore) return false;
        if (idstoreadmin != that.idstoreadmin) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idstore;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + idstoreadmin;
        return result;
    }

    public Collection<PromoEntity> getPromosByIdstore() {
        return promosByIdstore;
    }

    public void setPromosByIdstore(Collection<PromoEntity> promosByIdstore) {
        this.promosByIdstore = promosByIdstore;
    }

    public UsersEntity getUsersByIdstoreadmin() {
        return usersByIdstoreadmin;
    }

    public void setUsersByIdstoreadmin(UsersEntity usersByIdstoreadmin) {
        this.usersByIdstoreadmin = usersByIdstoreadmin;
    }

    public Collection<UsersEntity> getUsersByIdstore() {
        return usersByIdstore;
    }

    public void setUsersByIdstore(Collection<UsersEntity> usersByIdstore) {
        this.usersByIdstore = usersByIdstore;
    }
}
