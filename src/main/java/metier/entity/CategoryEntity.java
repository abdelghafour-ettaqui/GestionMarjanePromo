package metier.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "category", schema = "public", catalog = "marjane")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcategory")
    private int idcategory;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "idstoreadmin")
    private Integer idstoreadmin;
    @Basic
    @Column(name = "percentage")
    private String percentage;
    @OneToMany(mappedBy = "categoryByIdcategory")
    private Collection<PromoEntity> promosByIdcategory;
    @OneToMany(mappedBy = "categoryByIdcategory")
    private Collection<SubcategoryEntity> subcategoriesByIdcategory;
    @OneToMany(mappedBy = "categoryByIdcategory")
    private Collection<UsersEntity> usersByIdcategory;

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdstoreadmin() {
        return idstoreadmin;
    }

    public void setIdstoreadmin(Integer idstoreadmin) {
        this.idstoreadmin = idstoreadmin;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (idcategory != that.idcategory) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (idstoreadmin != null ? !idstoreadmin.equals(that.idstoreadmin) : that.idstoreadmin != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcategory;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (idstoreadmin != null ? idstoreadmin.hashCode() : 0);
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        return result;
    }

    public Collection<PromoEntity> getPromosByIdcategory() {
        return promosByIdcategory;
    }

    public void setPromosByIdcategory(Collection<PromoEntity> promosByIdcategory) {
        this.promosByIdcategory = promosByIdcategory;
    }

    public Collection<SubcategoryEntity> getSubcategoriesByIdcategory() {
        return subcategoriesByIdcategory;
    }

    public void setSubcategoriesByIdcategory(Collection<SubcategoryEntity> subcategoriesByIdcategory) {
        this.subcategoriesByIdcategory = subcategoriesByIdcategory;
    }

    public Collection<UsersEntity> getUsersByIdcategory() {
        return usersByIdcategory;
    }

    public void setUsersByIdcategory(Collection<UsersEntity> usersByIdcategory) {
        this.usersByIdcategory = usersByIdcategory;
    }
}
