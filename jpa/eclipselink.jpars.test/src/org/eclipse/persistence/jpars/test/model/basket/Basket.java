/*******************************************************************************
 * Copyright (c) 2014 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *      Dmitry Kornilov - Initial implementation
 ******************************************************************************/
package org.eclipse.persistence.jpars.test.model.basket;

import org.eclipse.persistence.jpa.rs.annotations.RestPageable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "JPARS_BASKET")
@NamedQueries({
        @NamedQuery(
                name = "Basket.deleteAll",
                query = "DELETE FROM Basket b")
})
public class Basket {

    @Id
    @Column(name = "BASKET_ID")
    private Integer id;

    @Column(name = "BASKET_NAME")
    private String name;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    @RestPageable(limit = 2)
    private List<BasketItem> basketItems = new ArrayList<BasketItem>();

    public Basket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basketItems=" + basketItems +
                '}';
    }
}
