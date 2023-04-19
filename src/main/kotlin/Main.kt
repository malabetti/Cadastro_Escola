val escolas = mutableListOf<Escola>()

fun removeEscola(codigo:Int) {
    for (i in escolas) {
        if (i.codigo == codigo) {
            escolas.remove(i)
            println("Escola ${i.nome} removida!")
            break
        }
    }
}

fun listarEscolas() {
    for (i in escolas) {
        digitaEscola(i)
    }
}

fun digitaEscola(i:Escola) {
    println("****" + i.nome + "****")
    println("Código: ${i.codigo}")
    println("Cidade: ${i.cidade}\n")
    println("Turmas:")
    for (j in i.turmas) {
        println(j.nome +" "+ j.serie)
        println("Professores:")
        for (k in j.professores)
            println(k.nome)
        println("Alunos:")
        for (k in j.alunos)
            println(k.nome)
    }
    println()
}

fun main() {
    var opc:Int
    do {
        print("1-Cadastrar escola\n2-Remover escola\n3-Listar escolas\n4-Configurar escola\n5-Sair\n-> ")
        opc = readln().toInt()
        when (opc) {
            1 -> {
                print("Digite o nome da escola: ")
                val nome = readln()
                print("Digite a cidade da escola: ")
                val cidade = readln()
                print("Digite o código da escola: ")
                val codigo = readln().toInt()
                escolas.add(Escola(nome, cidade, codigo))
                println("Escola cadastrada!")
            }
            2 -> {
                print("Digite o código da escola: ")
                val codigo = readln().toInt()
                removeEscola(codigo)
            }
            3 -> listarEscolas()
            4 -> {
                print("Digite o código da escola: ")
                var codigo = readln().toInt()
                var e = Escola("", "", -1)
                for (i in escolas) {
                    if (i.codigo == codigo) {
                        e = i
                        break
                    }
                }
                codigo = escolas.indexOf(e)
                do {
                    println("Escola ${e.nome}")
                    print("1-Adicionar turma\n2-Configurar turma\n3-Sair\n-> ")
                    val opc2 = readln().toInt()
                    when(opc2) {
                        1 -> {
                            print("Digite o nome da turma: ")
                            val nome = readln()
                            print("Digite a série da turma: ")
                            val serie = readln()
                            //escolas[codigo].turmas.add(Turma().cadastraTurma(nome, serie))
                            escolas[codigo].turmas.add(Turma(nome, serie))
                            println("Turma cadastrada!")
                        }
                        2 -> {
                            do {
                                print("1-Adicionar professor\n2-Adicionar aluno\n3-Sair\n-> ")
                                val opc3 = readln().toInt()
                                when (opc3) {
                                    1 -> {
                                        print("Digite o nome da turma: ")
                                        val turmaNome = readln()
                                        print("Digite o nome: ")
                                        val nome = readln()
                                        print("Digite a matéria: ")
                                        val materia = readln()
                                        var n:Int
                                        for (i in escolas[codigo].turmas) {
                                            if (i.nome == turmaNome) {
                                                n = escolas[codigo].turmas.indexOf(i)
                                                escolas[codigo].turmas[n].professores.add(Professor(nome, materia))
                                                break
                                            }
                                        }
                                    }
                                    2 -> {
                                        print("Digite o nome da turma: ")
                                        val turmaNome = readln()
                                        print("Digite o nome: ")
                                        val nome = readln()
                                        var n:Int
                                        for (i in escolas[codigo].turmas) {
                                            if (i.nome == turmaNome) {
                                                n = escolas[codigo].turmas.indexOf(i)
                                                escolas[codigo].turmas[n].alunos.add(Aluno(nome))
                                                break
                                            }
                                        }
                                    }
                                    3 -> println("Saindo!")
                                    else -> println("Opção inválida!")
                                }
                            } while (opc3 != 3)
                        }
                        3 -> println("Saindo!")
                        else -> println("Opção inválida!")
                    }
                } while (opc2 != 3)
            }
            5 -> println("Saindo!")
            else -> println("Opção inválida!")
        }
    } while (opc != 5)
}