class Aluno {
    var nome:String? = null

    fun cadastraAluno(nomec:String):Aluno {
        nome = nomec
        return this
    }
}