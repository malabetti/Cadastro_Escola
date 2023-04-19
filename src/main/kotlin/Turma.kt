class Turma {
    var nome:String? = null
    var serie:String? = null
    var professores = mutableListOf<Professor>()
    var alunos = mutableListOf<Aluno>()

    fun cadastraTurma(nomec:String, seriec:String):Turma {
        nome = nomec
        serie = seriec
        return this
    }
}