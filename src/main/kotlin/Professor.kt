class Professor {
    var nome:String? = null
    var materia:String? = null

    fun cadastraProf(nomec:String, materiac:String):Professor {
        nome = nomec
        materia = materiac
        return this
    }
}