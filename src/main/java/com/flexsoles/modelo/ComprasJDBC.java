package com.flexsoles.modelo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.flexsoles.persistencia.Compra;

@Repository
public class ComprasJDBC extends DaoGenericoImpl<Compra>  implements ComprasDAO {


}
