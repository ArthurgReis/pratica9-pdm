package com.br.pratica9_pdm

import java.io.Serializable

data class Destino(
    val nome: String,
    val foto: Int,
    val descCurta: String,
    val descLonga: String,
    val pontosTuristicos: List<String>
) : Serializable