/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.dao;

import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import java.util.ArrayList;

/**
 *
 * @author Operator
 */
public interface PengembalianDAO {
    
    ArrayList<Regional> getRegional();
    ArrayList<Regional> getIsiRegional(Object pilihan);
    ArrayList<Produk> getProdukPrangko(Object pilihan);
}
