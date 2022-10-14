# Estoque de Livros

Esse programa foi realizado como uma forma de praticar e estudar os elementos e funções do Java antes da prova aplicada de POO da turma de 2021 na UFJ.

Ele permite o usuário selecionar um autor e uma editora predeterminada pelo software, além de adicionar o título do livro e assimilar o seu *serial* ao mesmo.

Um vídeo demosntrativo de sua execução está disponível aqui:

https://user-images.githubusercontent.com/110516080/195930684-12c18986-57fe-4f92-95dc-63316b443ea1.mp4

Para ler o código fonte, basta acessar a pasta [`src`](/Livros/src), caso deseja compilar e executar o programa em Java, a classe principal é o [`TesteProva.java`](/Livros/src/Controller/TesteProva.java).

## Funcionalidades

- Registre um livro com as informações do mesmo
- Ao adicionar uma quantidade maior que 0 e caso o *serial* do livro não seja utilizado por outro livro, o livro é registrado com sucesso na programa
- Ao remover um exemplar do estoque, a sua quantia dos livros exemplares é subtraída em 1, caso não exista mais livros do mesmo, o livro será removido do programa
