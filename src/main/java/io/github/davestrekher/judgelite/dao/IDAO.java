package io.github.davestrekher.judgelite.dao;

import io.github.davestrekher.judgelite.model.listaDinamica;;

public interface IDAO<T, K> {
   public listaDinamica<T> getAllData();

   public void createData(T data);

   public T readData(K primaryKey);
   /**
    * public void updateData(T data);
    * public void deleteData(T data);
    **/
}