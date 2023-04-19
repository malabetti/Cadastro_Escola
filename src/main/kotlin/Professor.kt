class Professor (var nome: String, var materia: String){

    fun cadastraProf(nomec:String, materiac:String):Professor {
        nome = nomec
        materia = materiac
        return this
    }
}