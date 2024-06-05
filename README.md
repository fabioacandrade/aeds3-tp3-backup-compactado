# AEDsIII - TP03
## Rotinas Implementadas
- Compactação e descompactação de arquivos utilizando o algoritmo LZW
- Backup de arquivos
- Metodos criados:
    - `void listarBackups()` - Lista todos os backups realizados.
    - `void recuperarBackup(File path)` - A partir de um path, recupera um backup.
    - `boolean criarBackup()` - Cria uma pasta de backup com a data do momento, alem de adicionar cada backup feito à ela.
    - `void escreverBackup(String arquivo, String origem, String destino)` - Escreve um arquivo de backup.
    - `void escreverRecuperacao(String arquivo, String origem, String destino)` - Escreve o conteudo de um arquivo de backup.
    - `void excluirPasta(File pasta)`  - Exclui uma pasta e todos os arquivos dentro dela.
    - `void excluirArquivos(File pasta)` - Esvazia uma pasta.
## Relato do Grupo
- Todos os requisitos do projeto foram implementados com sucesso. A etapa mais desafiadora foi a configuração dos backups, que exigiu a criação de um sistema que permitisse aos usuários escolherem quais arquivos desejavam salvar. Além disso, o desenvolvimento do projeto foi uma experiência enriquecedora, tanto em termos de diversão quanto de aprendizado. Nosso grupo pôde compreender a importância e o funcionamento da compactação utilizando o algoritmo LZW, o que contribuiu significativamente para o nosso conhecimento nesta área.
## Questionário
- Há uma rotina de compactação utilizando o algoritmo LZW para fazer o backup dos arquivos? **Sim**
- Há uma rotina de descompactação usando o algoritmo LZW para recuperação dos arquivos? **Sim**
- O usuário pode escolher a versão a recuperar? **Sim**
- Qual foi a taxa de compressão alcançada por esse backup? (Compare o tamanho dos arquivos compactados com os arquivos originais) **1,6**
- O trabalho está funcionando corretamente? **Sim**
- O trabalho está completo? **Sim**
- O trabalho é original e não a cópia de um trabalho de um colega? **Sim**
## Autores
- [@fabioacandrade](https://www.github.com/fabioacandrade)
- [@LucasAlkmimBarros](https://www.github.com/LucasAlkmimBarros)
- [@Marcal08](https://www.github.com/Marcal08)
- [@PRMaia](https://www.github.com/PRMaia)

