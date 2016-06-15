-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-01-25 03:04:31
-- 服务器版本： 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `newsdemo`
--

-- --------------------------------------------------------

--
-- 表的结构 `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `desc` text NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content_url` text NOT NULL,
  `pic_url` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `news`
--

INSERT INTO `news` (`id`, `title`, `desc`, `time`, `content_url`, `pic_url`) VALUES
(1, '极客学院客户端重磅上线', '极客学院客户端重磅上线 最新课程随时登陆学习', '2015-01-24 01:50:03', 'http://www.jikexueyuan.com/blog/41.html', 'http://www.lagou.com/upload/logo/3cbd0428dc524d37a669aebd04fd2ca7.jpg'),
(2, '极客学院新课发布', 'C语言输入与输出', '2015-01-24 01:50:59', 'http://www.jikexueyuan.com/blog/43.html', 'http://a1.jikexueyuan.com/home/201405/23/6ea7/537eaf51ae609.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
