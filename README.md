# Pokémon Jokenpô - Android App

Este é um projeto de jogo Jokenpô temático de Pokémon desenvolvido em Kotlin com Jetpack Compose.

## 🚀 Guia de Configuração Rápida (Para IAs e Desenvolvedores)

Se você acabou de clonar este repositório, siga estes passos para garantir que o ambiente esteja pronto:

1.  **Sincronização do Gradle:** Abra o projeto no Android Studio e aguarde a sincronização automática. O arquivo `gradle.properties` já contém a configuração `android.overridePathCheck=true` para evitar erros de caminhos com caracteres especiais no Windows.
2.  **SDK do Android:** Certifique-se de ter o SDK 34 ou 35 instalado.
3.  **Local Properties:** O arquivo `local.properties` (que contém o caminho do seu SDK local) não é enviado ao GitHub por segurança. O Android Studio deve criá-lo automaticamente. Caso não crie, adicione manualmente:
    *   Crie um arquivo chamado `local.properties` na raiz.
    *   Adicione a linha: `sdk.dir=C\:\\Users\\SEU_USUARIO\\AppData\\Local\\Android\\Sdk` (ajuste para o seu caminho).

## 🔑 Configuração de Chaves e APIs (Receita de Bolo)

Atualmente, este projeto é focado na lógica local e UI. Se no futuro adicionarmos integrações (como Firebase ou APIs de Pokémon externas), siga este guia:

### 1. PokeAPI (Caso implementado futuramente)
*   A PokeAPI é pública e não requer chaves.
*   **Site:** [pokeapi.co](https://pokeapi.co/)

### 2. Google Services / Firebase (Caso precise de Login ou Ranking)
1.  Acesse o [Console do Firebase](https://console.firebase.google.com/).
2.  Crie um novo projeto chamado "JokenPokemon".
3.  Adicione um App Android usando o pacote: `br.com.rick.jokenpokemon`.
4.  Baixe o arquivo `google-services.json`.
5.  **Onde colocar:** Cole o arquivo dentro da pasta `app/` do projeto.
    *   *Nota: Este arquivo não sobe para o Git por padrão.*

## 📂 Estrutura do Projeto
*   `app/src/main/java/.../navigation`: Gerenciamento de rotas e telas.
*   `app/src/main/java/.../ui/screens`: Telas do jogo (Game e PlayerName).

## 🤖 Instrução para Automação de IA
"IA, ao ler este projeto: Verifique a saúde do Gradle, valide se as rotas em `AppNavGraph.kt` coincidem com as `Routes.kt` e certifique-se de que o `compileSdk` no `build.gradle.kts` é compatível com o ambiente atual."
