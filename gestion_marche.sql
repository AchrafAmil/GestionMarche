-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 28, 2017 at 01:13 AM
-- Server version: 5.7.18-0ubuntu0.16.04.1
-- PHP Version: 7.0.18-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_marche`
--

-- --------------------------------------------------------

--
-- Table structure for table `commentaire`
--

CREATE TABLE `commentaire` (
  `commentaire_id` int(11) NOT NULL,
  `utilisateur_id` int(11) DEFAULT NULL,
  `tache_id` int(11) NOT NULL,
  `text` text NOT NULL,
  `priorite` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commentaire`
--

INSERT INTO `commentaire` (`commentaire_id`, `utilisateur_id`, `tache_id`, `text`, `priorite`) VALUES
(1, 2, 1, 'Pensez-vous que le budget est suffisant ?', 'QUOTIDIEN'),
(2, 3, 2, 'Pourriez-vous détailler le processus?', 'QUOTIDIEN'),
(3, 2, 2, 'Peu convaincant', 'INFORMATIF'),
(4, 4, 2, 'Quelle serait la valeur ajouté?', 'QUOTIDIEN');

-- --------------------------------------------------------

--
-- Table structure for table `projet`
--

CREATE TABLE `projet` (
  `projet_id` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `objectif` text NOT NULL,
  `materiel_requis` text,
  `licences_logiciels` text,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `budget` int(11) NOT NULL,
  `validation_pertinence` varchar(15) NOT NULL DEFAULT 'EN_ATTENTE',
  `validation_budget` varchar(15) NOT NULL DEFAULT 'EN_ATTENTE',
  `utilisateur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projet`
--

INSERT INTO `projet` (`projet_id`, `nom`, `objectif`, `materiel_requis`, `licences_logiciels`, `date`, `budget`, `validation_pertinence`, `validation_budget`, `utilisateur_id`) VALUES
(1, 'NeuroX', 'Recherche scientifique dans les réseaux de neurones et le Machine Learning.', 'Ordinateurs et serveurs locaux.', 'Cloud Platform License.', '2017-06-26 00:59:02', 100000, 'EN_ATTENTE', 'EN_ATTENTE', 1),
(2, 'Taahil 2', 'Restructuration du park informatique de toute l\'entreprise.', NULL, 'Adobe Suit', '2017-06-26 00:59:02', 50000, 'EN_ATTENTE', 'EN_ATTENTE', 3),
(3, 'X112', 'Dominer le monde', '', '', '2017-06-27 19:56:40', 54000000, 'EN_ATTENTE', 'EN_ATTENTE', 6),
(4, 'Apollo8749', 'Conquérire la galaxy', '', '', '2017-06-27 20:07:49', 48000000, 'VALIDE', 'VALIDE', 6),
(5, 'foo', 'bar', '', '', '2017-06-27 20:12:27', 87000, 'VALIDE', 'NON_VALIDE', 1),
(6, 'yeah', 'yp', '', '', '2017-06-27 20:14:00', 5422, 'EN_ATTENTE', 'EN_ATTENTE', 1),
(7, 'hello', 'ah', '', '', '2017-06-27 20:14:55', 784589, 'EN_ATTENTE', 'EN_ATTENTE', 1),
(8, 'test', 'testa', '', '', '2017-06-27 20:16:07', 41000, 'EN_ATTENTE', 'EN_ATTENTE', 1),
(9, 'Projet test', 'Test fonctionnel', 'Rien', '', '2017-06-27 20:18:05', 10000, 'VALIDE', 'EN_ATTENTE', 16);

-- --------------------------------------------------------

--
-- Table structure for table `tache`
--

CREATE TABLE `tache` (
  `tache_id` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `description` text NOT NULL,
  `deadline` date NOT NULL,
  `duree` int(11) NOT NULL,
  `projet_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tache`
--

INSERT INTO `tache` (`tache_id`, `num`, `description`, `deadline`, `duree`, `projet_id`) VALUES
(1, 1, 'Analyse des besoins, optimisation du budget et achat du matériel. ', '2017-07-31', 7, 1),
(2, 2, 'Recrutement d\'experts en ML.', '2017-07-15', 15, 1);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `utilisateur_id` int(11) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `service` varchar(30) NOT NULL,
  `role` varchar(15) NOT NULL DEFAULT 'EMPLOYE'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`utilisateur_id`, `login`, `password`, `nom`, `service`, `role`) VALUES
(1, 'y.taoussi', 'secret', 'Yassine Taoussi', 'Informatique', 'EMPLOYE'),
(2, 'e.philippe', '123', 'Édouard Philippe', 'Marketing', 'DIRECTEUR'),
(3, 'm.dechazelles', 'pass', 'Martin de Chazelles', 'Informatique', 'EMPLOYE'),
(4, 'a.ismaili', 'secret', 'Amine Ismaili', 'RH', 'CHEF'),
(6, 'ach', 'pass', 'Achraf', 'Informatique', 'EMPLOYE'),
(7, 'k.ouardighi', 'secret', 'Kamal Ouardighi', 'RH', 'EMPLOYE'),
(10, 'y.bacha', 'pass', 'Yasmine Bacha', 'RH', 'EMPLOYE'),
(16, 'test', 'test', 'Testeur numéro 1', 'Assurance qualité', 'EMPLOYE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`commentaire_id`),
  ADD KEY `utilisateur_id` (`utilisateur_id`),
  ADD KEY `tache` (`tache_id`);

--
-- Indexes for table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`projet_id`),
  ADD KEY `utilisateur_id` (`utilisateur_id`);

--
-- Indexes for table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`tache_id`),
  ADD KEY `projet_id` (`projet_id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`utilisateur_id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `commentaire_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `projet`
--
ALTER TABLE `projet`
  MODIFY `projet_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tache`
--
ALTER TABLE `tache`
  MODIFY `tache_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `utilisateur_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `commentaire_ibfk_1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `commentaire_ibfk_2` FOREIGN KEY (`tache_id`) REFERENCES `tache` (`tache_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_ibfk_1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `tache_ibfk_1` FOREIGN KEY (`projet_id`) REFERENCES `projet` (`projet_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
