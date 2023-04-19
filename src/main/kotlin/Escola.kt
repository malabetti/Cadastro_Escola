class Escola (var nome:String, var cidade: String, var codigo: Int){
    var turmas = mutableListOf<Turma>()

    fun adicionaTurma(nomec:String, seriec:String){
        turmas.add(Turma(nomec, seriec))
    }
}