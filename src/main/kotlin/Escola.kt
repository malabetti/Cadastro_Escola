class Escola {
    var nome:String? = null
    var cidade:String? = null
    var codigo:Int? = null
    var turmas = mutableListOf<Turma>()

    fun cadastraEscola(nomec:String, cidadec:String, codigoc:Int):Escola {
        nome = nomec
        cidade = cidadec
        codigo = codigoc
        return this
    }

    fun adicionaTurma(nomec:String, seriec:String){
        turmas.add(Turma().cadastraTurma(nomec, seriec))
    }
}