-- --------------------------------------------------------
-- Host:                         192.168.0.44
-- Versión del servidor:         5.7.14 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para youtube
DROP DATABASE IF EXISTS `youtube`;
CREATE DATABASE IF NOT EXISTS `youtube` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `youtube`;

-- Volcando estructura para tabla youtube.amaia-perros
DROP TABLE IF EXISTS `amaia-perros`;
CREATE TABLE IF NOT EXISTS `amaia-perros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `raza` varchar(50) NOT NULL DEFAULT '0',
  `img` varchar(100) NOT NULL DEFAULT '0',
  KEY `Índice 1` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.amaia-perros: 4 rows
DELETE FROM `amaia-perros`;
/*!40000 ALTER TABLE `amaia-perros` DISABLE KEYS */;
INSERT INTO `amaia-perros` (`id`, `raza`, `img`) VALUES
	(1, 'Bulldog', 'https://www.elmundodelperro.net/fotos/91/3249_18m_01_thumb_690.jpg'),
	(2, 'Pastor alemán', 'https://www.mundoperros.es/wp-content/uploads/2016/11/cachorro-joven-de-pastor-aleman-830x553.jpg'),
	(3, 'Labrador retriever', 'https://t2.ea.ltmcdn.com/es/razas/0/0/1/img_100_labrador-retriever_0_600.jpg'),
	(4, 'Beagle', 'https://t1.ea.ltmcdn.com/es/razas/0/4/3/img_340_beagle_0_600.jpg');
/*!40000 ALTER TABLE `amaia-perros` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.andersolana
DROP TABLE IF EXISTS `andersolana`;
CREATE TABLE IF NOT EXISTS `andersolana` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `url` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=504 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.andersolana: 4 rows
DELETE FROM `andersolana`;
/*!40000 ALTER TABLE `andersolana` DISABLE KEYS */;
INSERT INTO `andersolana` (`id`, `nombre`, `url`) VALUES
	(500, 'estomago', 'zB3oRJf-Mjw'),
	(501, 'cancion', 'v9Jga7QBEpA'),
	(502, 'aprender', '57vsC8WnQpM'),
	(503, 'cancion2', 'fJ9rUzIMcZQ');
/*!40000 ALTER TABLE `andersolana` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.andoni videos
DROP TABLE IF EXISTS `andoni videos`;
CREATE TABLE IF NOT EXISTS `andoni videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.andoni videos: 2 rows
DELETE FROM `andoni videos`;
/*!40000 ALTER TABLE `andoni videos` DISABLE KEYS */;
INSERT INTO `andoni videos` (`id`, `titulo`, `url`) VALUES
	(1, 'Vitas  7th element', 'https://www.youtube.com/watch?v=IwzUs1IMdyQ'),
	(2, 'Gandalf Epic ', 'https://www.youtube.com/watch?v=6n8c-PjlZBY');
/*!40000 ALTER TABLE `andoni videos` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.borja
DROP TABLE IF EXISTS `borja`;
CREATE TABLE IF NOT EXISTS `borja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.borja: 3 rows
DELETE FROM `borja`;
/*!40000 ALTER TABLE `borja` DISABLE KEYS */;
INSERT INTO `borja` (`id`, `titulo`, `url`) VALUES
	(1, 'Zumo de MAcho - 4 calvos', 'https://www.youtube.com/embed/WUktXQgYxPA'),
	(2, 'Zumo de MAcho - Lucha (Video Clip)', 'https://www.youtube.com/embed/d2UvQYLQ9A8'),
	(3, 'Rise Against - Prayer Of The Refugee', 'https://www.youtube.com/embed/9-SQGOYOjxs');
/*!40000 ALTER TABLE `borja` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.carrito_perros_borja
DROP TABLE IF EXISTS `carrito_perros_borja`;
CREATE TABLE IF NOT EXISTS `carrito_perros_borja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perro` int(11) NOT NULL DEFAULT '0',
  `cantidad` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.carrito_perros_borja: 3 rows
DELETE FROM `carrito_perros_borja`;
/*!40000 ALTER TABLE `carrito_perros_borja` DISABLE KEYS */;
INSERT INTO `carrito_perros_borja` (`id`, `perro`, `cantidad`) VALUES
	(1, 1, 23),
	(2, 2, 13),
	(3, 3, 3);
/*!40000 ALTER TABLE `carrito_perros_borja` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.comentario
DROP TABLE IF EXISTS `comentario`;
CREATE TABLE IF NOT EXISTS `comentario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `texto` text CHARACTER SET latin1 NOT NULL,
  `aprobado` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0=Sin aprobar\n1=Aprobado',
  `id_video` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `comentario_has_usuario_idx` (`id_usuario`),
  KEY `comentario_has_video_idx` (`id_video`),
  CONSTRAINT `comentario_has_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comentario_has_video` FOREIGN KEY (`id_video`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.comentario: ~2 rows (aproximadamente)
DELETE FROM `comentario`;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` (`id`, `fecha`, `texto`, `aprobado`, `id_video`, `id_usuario`) VALUES
	(1, '2018-10-11 09:13:16', 'ME he reido mucho, gran video', 0, 1, 2),
	(2, '2018-10-11 09:14:33', 'vaya mierda', 0, 1, 3);
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.daniel
DROP TABLE IF EXISTS `daniel`;
CREATE TABLE IF NOT EXISTS `daniel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `url` varchar(100) NOT NULL,
  KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.daniel: 3 rows
DELETE FROM `daniel`;
/*!40000 ALTER TABLE `daniel` DISABLE KEYS */;
INSERT INTO `daniel` (`id`, `nombre`, `url`) VALUES
	(1, 'Majes En Moto', 'xuzjaUdwmw0'),
	(2, 'Noriyaro', 'UPsbnt7vUo4'),
	(3, 'Madrid Riders\r\n', 'kCff15rxl84');
/*!40000 ALTER TABLE `daniel` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.danielperros
DROP TABLE IF EXISTS `danielperros`;
CREATE TABLE IF NOT EXISTS `danielperros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `raza` varchar(50) NOT NULL DEFAULT '0',
  `origen` varchar(100) NOT NULL DEFAULT '0',
  `img` varchar(1000) NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.danielperros: 3 rows
DELETE FROM `danielperros`;
/*!40000 ALTER TABLE `danielperros` DISABLE KEYS */;
INSERT INTO `danielperros` (`id`, `raza`, `origen`, `img`) VALUES
	(1, 'Shih Tzu', 'República Popular China, Tíbet', 'https://petyzoo.com/wp-content/uploads/2017/10/shih-tzu-razas-perros-cuidados-alimentacion.jpg'),
	(2, 'Golden retriever', 'Reino Unido, Escocia, Inglaterra', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRn2vuFbLoH5pvd-9bsAtNX1ddZVnS2fU4TBrgA6eX_m5YGlqzusw'),
	(3, 'Husky siberiano', 'Siberia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Le%C3%AFko_au_bois_de_la_Cambre.jpg/220px-Le%C3%AFko_au_bois_de_la_Cambre.jpg');
/*!40000 ALTER TABLE `danielperros` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.endika_perros
DROP TABLE IF EXISTS `endika_perros`;
CREATE TABLE IF NOT EXISTS `endika_perros` (
  `id` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `raza` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.endika_perros: 0 rows
DELETE FROM `endika_perros`;
/*!40000 ALTER TABLE `endika_perros` DISABLE KEYS */;
/*!40000 ALTER TABLE `endika_perros` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.endika_video
DROP TABLE IF EXISTS `endika_video`;
CREATE TABLE IF NOT EXISTS `endika_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.endika_video: 5 rows
DELETE FROM `endika_video`;
/*!40000 ALTER TABLE `endika_video` DISABLE KEYS */;
INSERT INTO `endika_video` (`id`, `nombre`, `url`) VALUES
	(1, 'Parkway', 'YuG4-lewUTs'),
	(2, 'Volbeat\r\n\r\n', '7WdO9KhcUKE'),
	(3, 'Arch Enemy', 'mjF1rmSV1dM'),
	(4, 'Lamb Of God', 'oVW8gcse4g'),
	(5, 'Trivium', 'IIvSXocE6YY');
/*!40000 ALTER TABLE `endika_video` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.hector_albumes
DROP TABLE IF EXISTS `hector_albumes`;
CREATE TABLE IF NOT EXISTS `hector_albumes` (
  `id` int(11) NOT NULL,
  `artista` varchar(50) DEFAULT NULL,
  `album` varchar(100) DEFAULT NULL,
  `cover` varchar(500) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.hector_albumes: 0 rows
DELETE FROM `hector_albumes`;
/*!40000 ALTER TABLE `hector_albumes` DISABLE KEYS */;
INSERT INTO `hector_albumes` (`id`, `artista`, `album`, `cover`) VALUES
	(1, 'Franz Schubert, PD', 'AMDS00 Schubert - Piano Duets', 'https://www.piet-mondrian.org/images/paintings/red-tree.jpg'),
	(2, 'Arch Echo', 'Arch Echo', 'https://f4.bcbits.com/img/a4177598403_10.jpg');
/*!40000 ALTER TABLE `hector_albumes` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.hector_videos
DROP TABLE IF EXISTS `hector_videos`;
CREATE TABLE IF NOT EXISTS `hector_videos` (
  `id` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.hector_videos: 5 rows
DELETE FROM `hector_videos`;
/*!40000 ALTER TABLE `hector_videos` DISABLE KEYS */;
INSERT INTO `hector_videos` (`id`, `nombre`, `url`) VALUES
	(1, 'Plini - "Sunhead" (2018)', 'OMnj7bOY4E0'),
	(2, 'Jacob Collier - With The Love In My Heart', 'IlFD298wTOM'),
	(3, 'Schubert\'s Fantasy in F minor for Piano Four Hands, D940', 'aO5fLLHj55k'),
	(4, 'Arch Echo - Color Wheel', 'F65IQmP7lCk'),
	(5, 'Freak Kitchen - Confusion To The Enemy', 'AdzokBL0JNM');
/*!40000 ALTER TABLE `hector_videos` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.imanol
DROP TABLE IF EXISTS `imanol`;
CREATE TABLE IF NOT EXISTS `imanol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `url` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.imanol: 6 rows
DELETE FROM `imanol`;
/*!40000 ALTER TABLE `imanol` DISABLE KEYS */;
INSERT INTO `imanol` (`id`, `nombre`, `url`) VALUES
	(1, 'Aritz Aznar BMW e36 drift', 'https://www.youtube.com/watch?v=WSgNhiZPqx8'),
	(2, 'Trailer OSD Drift', 'https://www.youtube.com/watch?v=tthCwSHOqzA'),
	(3, 'Rallycross miranda', 'https://www.youtube.com/watch?v=WhumktdAwIM'),
	(4, 'Motorshow', 'https://www.youtube.com/watch?v=yePN64ArROM'),
	(5, 'SERGI MORILLA SUBIDA OPAKUA 2015 ', 'https://www.youtube.com/watch?v=2vYosKNMLus'),
	(6, 'RALLYE GURIEZO 2015 BMW E30', 'https://www.youtube.com/watch?v=NFXJRks1nFo');
/*!40000 ALTER TABLE `imanol` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.mikel_videos
DROP TABLE IF EXISTS `mikel_videos`;
CREATE TABLE IF NOT EXISTS `mikel_videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.mikel_videos: 3 rows
DELETE FROM `mikel_videos`;
/*!40000 ALTER TABLE `mikel_videos` DISABLE KEYS */;
INSERT INTO `mikel_videos` (`id`, `nombre`, `url`) VALUES
	(1, 'Fredrik\'s DRIFT', 'TLoAdsj5jRo'),
	(2, 'Fredrik Sørlie\'s Scandinavian Flickfest', '_1ZauQdvlqo'),
	(3, 'BRING BACK THE TOUGE', 'Rq2ktZSyoEo');
/*!40000 ALTER TABLE `mikel_videos` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.oscar
DROP TABLE IF EXISTS `oscar`;
CREATE TABLE IF NOT EXISTS `oscar` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `url` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.oscar: 8 rows
DELETE FROM `oscar`;
/*!40000 ALTER TABLE `oscar` DISABLE KEYS */;
INSERT INTO `oscar` (`id`, `nombre`, `url`) VALUES
	(1, 'Metallica - The Day that Never Comes', 'dkNfNR1WYMY'),
	(5, 'Megadeth - Tornado of souls', 'Lcm9qqo_qB0'),
	(3, 'Leo Jimenez - La era de la individualidad', 'BEor_JrwLs0'),
	(4, 'Iron Maiden - Fear of the Dark', 'J0N1yY937qg'),
	(6, 'Pantera - Revolution is My Name', '_XI1DD_vJuY'),
	(7, 'Arch Enemy - Never Forgive, Never Forget', 'mIFSmAp9C28'),
	(8, 'Manowar - Black wind, fire and Steel', '2b0qCPGAOo8'),
	(9, 'Camela - Nunca debi enamorame ', 'H-Rj1IYUe0U');
/*!40000 ALTER TABLE `oscar` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.perros
DROP TABLE IF EXISTS `perros`;
CREATE TABLE IF NOT EXISTS `perros` (
  `id` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `raza` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.perros: 0 rows
DELETE FROM `perros`;
/*!40000 ALTER TABLE `perros` DISABLE KEYS */;
/*!40000 ALTER TABLE `perros` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.perros_borja
DROP TABLE IF EXISTS `perros_borja`;
CREATE TABLE IF NOT EXISTS `perros_borja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `raza` varchar(50) NOT NULL,
  `imagen` varchar(150) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.perros_borja: 3 rows
DELETE FROM `perros_borja`;
/*!40000 ALTER TABLE `perros_borja` DISABLE KEYS */;
INSERT INTO `perros_borja` (`id`, `raza`, `imagen`, `precio`) VALUES
	(1, 'Beagle', 'https://t1.ea.ltmcdn.com/es/razas/0/4/3/img_340_beagle_0_600.jpg', 150),
	(2, 'Boxer', 'https://www.petdarling.com/articulos/wp-content/uploads/2014/08/boxer.jpg', 207.52),
	(3, 'Akita Inu', 'https://t1.ea.ltmcdn.com/es/razas/7/0/1/img_107_akita-inu-o-akita-japones_0_600.jpg', 189.25);
/*!40000 ALTER TABLE `perros_borja` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.perros_oscar
DROP TABLE IF EXISTS `perros_oscar`;
CREATE TABLE IF NOT EXISTS `perros_oscar` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` text,
  `raza` text NOT NULL,
  `chip` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.perros_oscar: 5 rows
DELETE FROM `perros_oscar`;
/*!40000 ALTER TABLE `perros_oscar` DISABLE KEYS */;
INSERT INTO `perros_oscar` (`id`, `nombre`, `raza`, `chip`) VALUES
	(1, 'Draco', 'Alaskan Malamute', 111111111),
	(2, 'Thor', 'Husky Siberiano', 222222222),
	(3, 'Rex', 'Pastor Aleman', 333333333),
	(4, 'Nahia', 'Samoyedo', 444444444),
	(5, 'Batman', 'Doberman', 555555555);
/*!40000 ALTER TABLE `perros_oscar` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.rol
DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.rol: ~4 rows (aproximadamente)
DELETE FROM `rol`;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id`, `nombre`) VALUES
	(1, 'administrador'),
	(7, 'otro'),
	(8, 'txerif'),
	(2, 'usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET latin1 NOT NULL,
  `password` varchar(20) CHARACTER SET latin1 NOT NULL,
  `id_rol` int(11) DEFAULT '2',
  `github` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `usuario_has_rol_idx` (`id_rol`),
  CONSTRAINT `usuario_has_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.usuario: ~26 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `password`, `id_rol`, `github`) VALUES
	(1, 'admin', 'admin', 1, NULL),
	(2, 'manolo@gmail.com', '12345', 2, NULL),
	(3, 'pepi@gmail.com', '12345', 2, NULL),
	(29, 'maria@gmail.com', '12345678', 2, NULL),
	(34, 'Javier', '098765432', 2, NULL),
	(44, 'David', '1234', 2, NULL),
	(51, 'Jose', '1234567890', 2, NULL),
	(52, 'marta', '1234567890', 2, NULL),
	(53, 'joserra', '1234567890', 2, NULL),
	(54, 'DON PIMPOM', '12345', 2, NULL),
	(57, 'TXEMA', '12345+6', 2, NULL),
	(60, 'endika@vazquez.com', 'endikavazquez', 2, 'Endika1994'),
	(68, 'borja@reyes.com', '446622', 2, 'AjRoBSeYeR'),
	(69, 'Hector@hector.com', 'qwerty', 2, NULL),
	(70, 'andoni_2006@hotmail.com', '010101', 2, 'andonishiraiwa'),
	(80, 'mikel@pires.com', '12345', 2, 'mikelpires'),
	(100, 'danielzallo@gmail.com', 'Daniel1234.', 2, 'dZallo'),
	(102, 'prueba@prueba.com', '0000', 2, NULL),
	(103, 'ander@ipartek.com', '12345678', 2, ''),
	(104, 'ander@solana.com', 'Pa$$w0rd', 2, 'AnderSolana'),
	(105, 'ima@gmail.com', 'Pa$$w0rd', 2, 'imaheripr'),
	(120, 'amaia@delolmo.com', '123456', 2, 'amaia9119'),
	(121, 'oscar@ipartek.com', 'Pa$$w0rd', 2, 'Behemoth95'),
	(122, 'DavidFerrero', '1234', 2, 'davidferreropeon'),
	(123, 'xabier@ipartek.com', 'Pa$$w0rd', 2, 'Xabage'),
	(124, 'lala@lala.com', 'Pa$$w0rd', 2, NULL),
	(125, 'Hector@Serrano.com', 'Qw3rt1', 2, NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.video
DROP TABLE IF EXISTS `video`;
CREATE TABLE IF NOT EXISTS `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(11) NOT NULL COMMENT 'identificador del video en youtube',
  `nombre` varchar(150) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `video_has_usuario_idx` (`id_usuario`),
  CONSTRAINT `video_has_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.video: ~13 rows (aproximadamente)
DELETE FROM `video`;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` (`id`, `codigo`, `nombre`, `id_usuario`) VALUES
	(1, 'i_cVJgIz_Cs', 'No te olvides de poner el Where en el Delete From. Maria', 29),
	(31, 'jJllPxkHGPE', 'Blancanieves y los siete enanitos: Ay ho/Cavar, cavar', 1),
	(32, 'UtF6Jej8yb4', 'Avicii I\'s - The Nights', 1),
	(38, 'aL6xNZ9pnbI', 'Miku Hatsune (Vocaloid) - Senbonzakura', 1),
	(40, 'sVwrQ2n13eQ', 'Autos de choque del FARY', 1),
	(41, 'bQMjEkkbHmU', 'Tijuana In Blue -- Enamorado de la muerte (cover)', 1),
	(42, 'Pzqr3rVZNso', 'EL RENO RENARDO - Camino Moria (videolyric by Azzurro)', 1),
	(43, 'p32b5nNq1zw', 'Iron Maiden - Fear of The Dark (HQ)', 1),
	(44, 'NFSyl3pwa-A', '"Maricarmen" - La Pegatina (videoclip oficial)', 1),
	(45, '0fgiBri5ZoA', 'Banda Bassotti - Juri Gagarin', 1),
	(46, 'wkjUEumfjFM', 'Banda Bassotti - Mockba \'993', 1),
	(47, 'j--2L3_FN08', 'SOZIEDAD ALKOHOLIKA - Piedra Contra Tijera (Video Oficial)', 1),
	(48, 'De-W9V-kCos', 'Marea - La Luna me sabe a poco', 44);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
