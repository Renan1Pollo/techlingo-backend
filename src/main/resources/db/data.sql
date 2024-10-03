-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: techlingo
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,_binary '','Python foi criado no final da década de 1980 por Guido van Rossum','Guido van Rossum',1),(2,_binary '\0','Python foi criado no final da década de 1980 por Guido van Rossum','Linus Torvalds',1),(3,_binary '\0','Python foi criado no final da década de 1980 por Guido van Rossum','James Gosling',1),(4,_binary '','Python é uma linguagem de programação de alto nível, conhecida por sua sintaxe simples e intuitiva, que facilita o aprendizado para iniciantes.','Linguagem de programação',2),(5,_binary '\0','Python é uma linguagem de programação de alto nível, conhecida por sua sintaxe simples e intuitiva, que facilita o aprendizado para iniciantes.','FrameWork Agil',2),(6,_binary '\0','Python é uma linguagem de programação de alto nível, conhecida por sua sintaxe simples e intuitiva, que facilita o aprendizado para iniciantes.','Uma ferramenta de Design',2),(7,_binary '\0','Python é amplamente utilizado em várias áreas, incluindo desenvolvimento web, análise de dados, inteligência artificial, aprendizado de máquina, automação de tarefas, e até no desenvolvimento de jogos.','Somente no desenvolvimento de aplicativos móveis.',3),(8,_binary '\0','Python é amplamente utilizado em várias áreas, incluindo desenvolvimento web, análise de dados, inteligência artificial, aprendizado de máquina, automação de tarefas, e até no desenvolvimento de jogos.','Apenas para criar sistemas operacionais.',3),(9,_binary '','Python é amplamente utilizado em várias áreas, incluindo desenvolvimento web, análise de dados, inteligência artificial, aprendizado de máquina, automação de tarefas, e até no desenvolvimento de jogos.','Desenvolvimento web, Análise de dados e IA.',3);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `contents`
--

LOCK TABLES `contents` WRITE;
/*!40000 ALTER TABLE `contents` DISABLE KEYS */;
INSERT INTO `contents` VALUES (1,NULL,1,'Python foi criado no final da década de 1980 por Guido van Rossum, com o objetivo de ser uma linguagem de programação de fácil leitura e escrita. A primeira versão foi lançada em 1991. Desde então, Python passou por várias atualizações, cada uma trazendo melhorias significativas em termos de recursos, performance e usabilidade. O nome “Python” foi inspirado no grupo de comédia britânico Monty Python, refletindo o desejo de Van Rossum de que a linguagem fosse divertida de usar.','História do Python',1),(2,NULL,2,'Python é uma linguagem de programação de alto nível, conhecida por sua sintaxe simples e intuitiva, que facilita o aprendizado para iniciantes. Suas características incluem tipagem dinâmica, o que significa que você não precisa declarar o tipo de uma variável antes de usá-la, e um extenso conjunto de bibliotecas que permitem realizar diversas tarefas sem precisar escrever muito código do zero. Isso torna Python uma excelente escolha para prototipagem rápida e desenvolvimento ágil.','Principais Vantagens da Linguagem Python',1),(3,NULL,3,'Python é amplamente utilizado em várias áreas, incluindo desenvolvimento web, análise de dados, inteligência artificial, aprendizado de máquina, automação de tarefas, e até no desenvolvimento de jogos. Frameworks como Django e Flask facilitam a criação de aplicativos web, enquanto bibliotecas como Pandas e NumPy são essenciais para manipulação e análise de dados.','Aplicações Diversificadas do Python no Mercado',1),(4,NULL,1,'Um algoritmo é uma lista de instruções ou um conjunto de passos que você segue para resolver um problema ou realizar uma tarefa. Pense em um algoritmo como uma receita de cozinha: você tem que seguir os passos em uma ordem específica para que o resultado seja como esperado. Na programação, usamos algoritmos para fazer o computador resolver problemas de forma organizada e eficiente. Um exemplo simples de algoritmo seria: \"1. Pegue um copo, 2. Abra a torneira, 3. Encha o copo de água.\" Se você seguir esses passos na ordem certa, vai conseguir um copo cheio de água. Assim funciona um algoritmo!','Entendendo Algoritmos',2),(5,NULL,2,'Na programação, muitas vezes precisamos que o computador faça algo só em certas condições. Para isso, usamos o comando \"se\" (ou if, em inglês). O comando \"se\" funciona como na vida real: por exemplo, \"se estiver chovendo, pegue um guarda-chuva\". O computador só executa uma ação se a condição que você definir for verdadeira. Vamos dizer que você está programando um jogo e quer que o personagem só pule se o jogador apertar a barra de espaço. Nesse caso, você diria para o computador: \"se a barra de espaço for pressionada, faça o personagem pular\". Assim, o computador só faz o que você mandar se a condição do \"se\" for atendida.','Tomando Decisões com \"Se\"',2),(6,NULL,3,'Na programação, muitas vezes precisamos repetir uma ação várias vezes. É aqui que entra o comando \"enquanto\" (ou while, em inglês). Esse comando diz ao computador para continuar fazendo algo \"enquanto\" uma certa condição for verdadeira. Imagine que você está programando um robô para colocar maçãs em uma cesta. Você diria: \"enquanto houver maçãs na mesa, continue colocando maçãs na cesta\". O robô vai continuar fazendo isso até que não reste mais nenhuma maçã. Da mesma forma, o computador continua repetindo as instruções até que a condição definida pare de ser verdadeira.','Repetindo Tarefas com \"Enquanto\"',2);
/*!40000 ALTER TABLE `contents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Python','Aprenda Python para desenvolver rapidamente qualquer coisa, desde aplicações web até inteligência artificial.','https://www.tshirtgeek.com.br/wp-content/uploads/2021/03/com001.jpg');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `enrollments`
--

LOCK TABLES `enrollments` WRITE;
/*!40000 ALTER TABLE `enrollments` DISABLE KEYS */;
INSERT INTO `enrollments` VALUES (1,0,0,'2024-10-02 15:51:25.979074',1,1);
/*!40000 ALTER TABLE `enrollments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','create table courses','SQL','V1__create_table_courses.sql',-1052610113,'root','2024-10-01 19:02:02',83,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lessons`
--

LOCK TABLES `lessons` WRITE;
/*!40000 ALTER TABLE `lessons` DISABLE KEYS */;
INSERT INTO `lessons` VALUES (1,1,'Python: Uma Introdução Simples e Versátil','Aqui iremos aprender um pouco mais sobre o que é o Python e como funciona.',100,1),(2,1,'Pensando como um Computador','Aprendendo fundamentos da Lógica de Programação',100,2),(3,1,'Variáveis e Tipos de Dados: Armazenando informações','Aqui iremos aprender a definir variáveis e os tipos de dados no python',100,3),(4,1,'Operadores aritméticos e lógicos: Realizando cálculos e comparações','Aqui iremos aprender os operadores aritméticos e lógicos ',100,4),(5,1,' Estruturas de controle: Tomando decisões e repetindo ações','Aqui iremos aprender a controlar o fluxo de execução de um programa.',100,5);
/*!40000 ALTER TABLE `lessons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,1,'Quem foi o criador do Python?',1),(2,1,'O que é python?',2),(3,1,'Em quais áreas o Python é amplamente utilizado?',3);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (1,1,'Unidade Básica de Python','Nesta unidade, vamos aprender os fundamentos da linguagem Python, como variáveis, tipos de dados e operadores',1000,1);
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2024-10-01 16:12:57.839502','renansk18@outlook.com','2024-10-02 22:37:14.885570',1,'Renan Pollo','renan123',400.00,'USER');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-03 15:41:38
