package com.dsg.desguambios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.desguambios.entidades.Desguace;

public interface DesguaceRepository extends JpaRepository<Desguace, String> {
}