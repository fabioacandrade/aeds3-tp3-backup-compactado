import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class Backup {
    public File pasta;

    public Backup() {

    }

    public Backup(String data) {
        pasta = new File("backups/backup_" + data);
        boolean resp = pasta.mkdir();
        if (resp == true) {
      //      System.out.println("Criou");
        } else {
      //      System.out.println("Nao criou");
        }

    }

    public static void listarBackups() {
        Scanner console = new Scanner(System.in);
        int i;
        File pasta = new File("backups");
        File[] arquivos = pasta.listFiles();

        int escolha = 0;
        do {
            System.out.println("Escolha um backup:");
            for (i = 0; i < arquivos.length; i++) {
                System.out.println(i + 1 + ") " + arquivos[i].getName());
            }
            escolha = Integer.valueOf(console.nextLine());
            if (escolha < 0 || escolha > arquivos.length) {
                System.out.println("Escolha uma opcao valida");
            }

        } while (escolha < 0 || escolha > arquivos.length);
        if (escolha != 0)

        recuperarBackup(arquivos[escolha - 1]);

        // Fazer backup do arquivo selecionado

    }

    public static boolean recuperarBackup(File path) {
        criarBackup();
        excluirArquivos(new File("dados/"));
        try {
            escreverRecuperacao("autores.db", path.toString() + "/", "dados/");
            escreverRecuperacao("autores.hash_c.db", path.toString()+ "/",  "dados/");
            escreverRecuperacao("autores.hash_d.db", path.toString()+ "/",  "dados/");
            escreverRecuperacao("categorias.db", path.toString()+ "/",  "dados/");
            escreverRecuperacao("categorias.hash_c.db", path.toString()+ "/",  "dados/");
            escreverRecuperacao("categorias.hash_d.db", path.toString()+ "/",  "dados/");
            escreverRecuperacao("livros.db", path.toString()+ "/",  "dados/");
            escreverRecuperacao("livros.hash_c.db", path.toString()+ "/",  "dados/");
            escreverRecuperacao("livros.hash_d.db", path.toString()+ "/",  "dados/");
            escreverRecuperacao("livros_categorias.btree.db",  path.toString() + "/", "dados/");
            escreverRecuperacao("livros_isbn.hash_c.db", path.toString()+ "/",  "dados/");
            escreverRecuperacao("livros_isbn.hash_d.db", path.toString()+ "/",  "dados/");
        System.out.println("\n \n \nBackup do arquivo feito com sucesso!");
            return true;
        }
         catch (Exception e) {
            System.out.println(e.getMessage());
            return false;

        }
    }

    public static boolean criarBackup() {
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm");
        Backup b = new Backup(dt.format(formatter));
        boolean resp = true;
        try {
            escreverBackup("autores.db", "dados/", b.pasta.toString());
            escreverBackup("autores.hash_c.db", "dados/", b.pasta.toString());
            escreverBackup("autores.hash_d.db", "dados/", b.pasta.toString());
            escreverBackup("categorias.db", "dados/", b.pasta.toString());
            escreverBackup("categorias.hash_c.db", "dados/", b.pasta.toString());
            escreverBackup("categorias.hash_d.db", "dados/", b.pasta.toString());
            escreverBackup("livros.db", "dados/", b.pasta.toString());
            escreverBackup("livros.hash_c.db", "dados/", b.pasta.toString());
            escreverBackup("livros.hash_d.db", "dados/", b.pasta.toString());
            escreverBackup("livros_categorias.btree.db", "dados/", b.pasta.toString());
            escreverBackup("livros_isbn.hash_c.db", "dados/", b.pasta.toString());
            escreverBackup("livros_isbn.hash_d.db", "dados/", b.pasta.toString());
            return resp;
        }

        catch (Exception e) {
            excluirPasta(b.pasta);
            return false;

        }
    }

    public static void escreverBackup(String arquivo, String origem, String destino) throws Exception {
        byte[] ba;
        FileInputStream fi = new FileInputStream(origem + arquivo);
        ba = fi.readAllBytes();
        //System.out.println(new String(ba));
        fi.close();
        FileOutputStream fo = new FileOutputStream(destino +  "/" + arquivo);
        ba = LZW.codifica(ba);
        fo.write(ba);
        fo.close();
        // System.out.println(new String(LZW.decodifica(ba)));
    }
    public static void escreverRecuperacao(String arquivo, String origem, String destino) throws Exception {
        byte[] ba;
        FileInputStream fi = new FileInputStream(origem + arquivo);
        ba = fi.readAllBytes();
        fi.close();
        FileOutputStream fo = new FileOutputStream(destino + "/" + arquivo);
        ba = LZW.decodifica(ba);
        // System.out.println(new String(ba));
        fo.write(ba);
        fo.close();
    }

    public static void excluirPasta(File pasta) {
        excluirArquivos(pasta);
        pasta.delete();
    }

    public static void excluirArquivos(File pasta) {
        if (pasta.exists()) {
            // Listar os arquivos na pasta
            File[] arquivos = pasta.listFiles();
            if (arquivos != null) {
                // Excluir cada arquivo na pasta (se for um diretório, chama recursivamente)
                for (File arquivo : arquivos) {
                    if (arquivo.isDirectory()) {
                        excluirPasta(arquivo); // Chama recursivamente para excluir subdiretórios
                    } else {
                        arquivo.delete(); // Exclui o arquivo
                    }
                }
            }
        }
    }
}
