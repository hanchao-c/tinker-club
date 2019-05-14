/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : tinker-order

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 14/05/2019 13:51:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_protocol
-- ----------------------------
DROP TABLE IF EXISTS `order_protocol`;
CREATE TABLE `order_protocol`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `item` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '条款',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_protocol
-- ----------------------------
INSERT INTO `order_protocol` VALUES ('0328c731c87f4e088c6567452abbf0ae', 'qoen7799UK');
INSERT INTO `order_protocol` VALUES ('03d661d1ad394bab887778b0fae263f2', 'n0hvOTRgP8');
INSERT INTO `order_protocol` VALUES ('0425a668969c4b548cc68f0674fe07cc', '7yLkIdPv1a');
INSERT INTO `order_protocol` VALUES ('044576c73a0b4bed966d0fe4f7bbc7d7', 'ApmVnA0MJ5');
INSERT INTO `order_protocol` VALUES ('0455f265b8b14ebf99240ac89baa4e42', 'PE1tMamQUr');
INSERT INTO `order_protocol` VALUES ('04a8cacf76b44429abfbde4e2c874b7e', 'YFIWnhyH8y');
INSERT INTO `order_protocol` VALUES ('0950890791184d36803d9110bb52256c', 'zyiDZxfadh');
INSERT INTO `order_protocol` VALUES ('0a240a8c2a864cf382e2314f893b29f6', 'ULtEXtISJ7');
INSERT INTO `order_protocol` VALUES ('0b891c2d9d5f47d083c71439f6bf9bd8', 'EZtdaGFfx5');
INSERT INTO `order_protocol` VALUES ('0bcc58ce6fc54b24b1881ea4565bf926', '64WQan7GqF');
INSERT INTO `order_protocol` VALUES ('0e16a9545da34705b9f261d88dbf04cf', 'IH5DK6OksI');
INSERT INTO `order_protocol` VALUES ('10828086250749879243603e2f4d8349', 'bZdfdjo7Bt');
INSERT INTO `order_protocol` VALUES ('10e099f932a846f683ee8727f0c9c6e3', 'tu17aqnmhM');
INSERT INTO `order_protocol` VALUES ('1237a55f167c4c1a9380e9ddab368445', '6LKSVVvGDJ');
INSERT INTO `order_protocol` VALUES ('138669fa24cb4264b78722dfda58cf1e', 'QGWihkPBRD');
INSERT INTO `order_protocol` VALUES ('14f44739aae149a0950dfcfc4c045d1c', '5YgyQHOHz6');
INSERT INTO `order_protocol` VALUES ('150b8cd29f4749628db9ad2cad261a92', '82rqFfJByv');
INSERT INTO `order_protocol` VALUES ('15972917887449ae9d7f38adf84ea2c9', 'XrIPLauXQi');
INSERT INTO `order_protocol` VALUES ('18f04d2e63b14b12835663b167c35fd7', 'x43bsEURWj');
INSERT INTO `order_protocol` VALUES ('1a8f5a68efb14ddbb0e168b69af00ac3', 'etkkOyvQ8O');
INSERT INTO `order_protocol` VALUES ('1aeb942e89a5465bad0fbde687a81810', 'WlXDNGLkfK');
INSERT INTO `order_protocol` VALUES ('1b1ff3292a3f40e898f66edc778ad657', 'b1e18u1DI3');
INSERT INTO `order_protocol` VALUES ('1b25c50ad01a4b4fbe6b572298f1a695', 'z4IfloD5ys');
INSERT INTO `order_protocol` VALUES ('1b395d0dd72a4ce5a9fa62d91367c5eb', 'N9W1h58oLE');
INSERT INTO `order_protocol` VALUES ('1b3e4fe1961c4f73bd39b775dda8c792', 'vz9H11cSSz');
INSERT INTO `order_protocol` VALUES ('1c219a4c0ec74e42a02fbde03db8bda1', 'ZMQ78qBce2');
INSERT INTO `order_protocol` VALUES ('1c228562bfe94e0aa9e0db8d19ce34a1', '57VNZIyto2');
INSERT INTO `order_protocol` VALUES ('1d4035cc96ac4cc2b6269af8d6d0f5c5', '9Ne2pWJ32L');
INSERT INTO `order_protocol` VALUES ('1e6544a143324ed6b23ef2d1a5d1786c', 'BDWDpmlIar');
INSERT INTO `order_protocol` VALUES ('1fecbadfb4b146068ca70a3d2693e255', 'Ff0MKbKshW');
INSERT INTO `order_protocol` VALUES ('201a58a1376d492f93e4e9b5cd083da7', 'EcgQ8C4Dvf');
INSERT INTO `order_protocol` VALUES ('204b6a1fdcc447c88c959c67d08c0c30', 'Y8U5MrJw2r');
INSERT INTO `order_protocol` VALUES ('225e21f1ed59481ebb326f99f12d7a3b', 'LPua93tGlI');
INSERT INTO `order_protocol` VALUES ('2496f47364e9404f9f0a3f5bad47cdb5', '0LS9Lu8kqL');
INSERT INTO `order_protocol` VALUES ('2670962cf195434691b1c7b833690158', 'k1OQrHpIDp');
INSERT INTO `order_protocol` VALUES ('2755a71e831e40a7b1529c5e745b6c1b', 'yakTMjMxTs');
INSERT INTO `order_protocol` VALUES ('276f67a321b84ea09043fe2923c985a8', '42sLepdj2u');
INSERT INTO `order_protocol` VALUES ('291cc44f314c437795bd3f90b6a228f0', 'O8Cqa2Ikqw');
INSERT INTO `order_protocol` VALUES ('296e639ac7ad45c5b3248995a709fbd0', 'LpxKg1yHUK');
INSERT INTO `order_protocol` VALUES ('2a3cb5ac162943198088aad558f59afe', 'Ivz6Ko1v0k');
INSERT INTO `order_protocol` VALUES ('2a5bbdebdb3349a59a1b922a81edd212', 'uUp9YcIaSR');
INSERT INTO `order_protocol` VALUES ('2ae8d67e62f045fca67753db39dc0106', 'XRqg1jmiJC');
INSERT INTO `order_protocol` VALUES ('2b17d2bb2f604ecf861b4d44f52a6306', 'yxibBs699q');
INSERT INTO `order_protocol` VALUES ('2b5f4b4b65854e13b66e4c3ba8ebb8e7', 'Y7XsQd09Kt');
INSERT INTO `order_protocol` VALUES ('2cfab950c4c448569065c360b8a94324', 'ddFgM2qxML');
INSERT INTO `order_protocol` VALUES ('2e01d502cfe4470d84d90c157a251c8d', 'CWcJhfeZQU');
INSERT INTO `order_protocol` VALUES ('2e191916e20a483ebbe7de63e0719e40', 'CbrqVghU48');
INSERT INTO `order_protocol` VALUES ('2e840aefb2a64e3db36b0f60a285a80c', 'oMd9SpiNOD');
INSERT INTO `order_protocol` VALUES ('2f220f66ea6542f0ba271e023f0fed0e', 'APMSXrpHJt');
INSERT INTO `order_protocol` VALUES ('2f3d661776314706a79cdacb72dd6eb7', 'g0kvdyvzIw');
INSERT INTO `order_protocol` VALUES ('2f8e7fab32234cacbf4f5f32a4fe7827', 'fArH0G9i9W');
INSERT INTO `order_protocol` VALUES ('2fe68655bf4947108b314e837185d622', 'I1wTp3SgxZ');
INSERT INTO `order_protocol` VALUES ('3094ca2ba9fc4c94a9564167c47a2a22', '1sLwlxe3ll');
INSERT INTO `order_protocol` VALUES ('309960538ce447ada086c505f2559ac8', 'sgQh8KXEnQ');
INSERT INTO `order_protocol` VALUES ('312b41694223417dbb56f18f9559baed', '6epfaNem8z');
INSERT INTO `order_protocol` VALUES ('32ced0bf156b4f45a2015a317e4f2548', 'jhhsaMh0JF');
INSERT INTO `order_protocol` VALUES ('334213f7acbe4021b84aaea7f2bfe29f', 'xcXMPFE1dw');
INSERT INTO `order_protocol` VALUES ('33beae0bfe14435ead5132ec2cd4b807', '1fETVeUjfV');
INSERT INTO `order_protocol` VALUES ('3580e5533e964637b4d556fd22aefa31', '5VepbGRdas');
INSERT INTO `order_protocol` VALUES ('35e320f3e1bb4671a2de6399ba74ccc7', 'bD3S4efVzI');
INSERT INTO `order_protocol` VALUES ('372aa77b01444907bae7710506cd3523', 'Po5FGcTMln');
INSERT INTO `order_protocol` VALUES ('37ee9b8cd76f4159b0866d42e261ed9e', 'eyFyQkfCpG');
INSERT INTO `order_protocol` VALUES ('38d0f2b43abb4089ae6dc3882bd149fd', 'xdjPj2sKaH');
INSERT INTO `order_protocol` VALUES ('3933539d503c4cb780275791e6518e5d', 'Qiaq6EUO9A');
INSERT INTO `order_protocol` VALUES ('393e6c24686a447982605faaf6962f79', 'Yi7u7ADQIc');
INSERT INTO `order_protocol` VALUES ('3c2bf7678dd346458232edd8afcfefed', 'EPammCJHd5');
INSERT INTO `order_protocol` VALUES ('3ca6745beeb44e518bc0fbd70b76553b', 'IsI1U4kfQH');
INSERT INTO `order_protocol` VALUES ('3e12821bf98140509483caa2c6e17fd4', 'DSMeRbs5nf');
INSERT INTO `order_protocol` VALUES ('3ecf42b9705f4547b14eb9eb8471e5ff', 'gaSEMFl4N5');
INSERT INTO `order_protocol` VALUES ('3fc88180ea5c4058b1bc920aecb02433', 'IvU4V5x3DE');
INSERT INTO `order_protocol` VALUES ('417d5241843345a28c5ead7946d92337', 'PKipDI0O3o');
INSERT INTO `order_protocol` VALUES ('430e839611934446afb491ab4155f545', 'xjEgw3nBXF');
INSERT INTO `order_protocol` VALUES ('43d4ec9d0b074b2997e085957e48338c', 'oZgE43szRi');
INSERT INTO `order_protocol` VALUES ('476eba7edc7044e08b232ba7045e5597', 'AcKkn8DyEv');
INSERT INTO `order_protocol` VALUES ('493c30614fd54afe9b8b20a22a701708', 'PEXWctrmyR');
INSERT INTO `order_protocol` VALUES ('4ac7cded852443dd8c02b099d148f9cf', '8mXHmU25pS');
INSERT INTO `order_protocol` VALUES ('4b43b0ccbb02465f9fe380d7d85364fc', 'M0rFXNB6hs');
INSERT INTO `order_protocol` VALUES ('4c964774fe384a5e8ab17c693c50cba7', 'CbDV1zCbBC');
INSERT INTO `order_protocol` VALUES ('4c9c7a621a684e428938fb329d89d1cb', 'UwcaFaQCxC');
INSERT INTO `order_protocol` VALUES ('4cb3483077ef4613868de2d0867560cc', 'PvazjBSUds');
INSERT INTO `order_protocol` VALUES ('5254d7cd4ac34d8887bb9895d826fa31', '7jaOQNRHO4');
INSERT INTO `order_protocol` VALUES ('52d7bf4e05624fc09b1566045572451c', 'JIoBJBN3XF');
INSERT INTO `order_protocol` VALUES ('5321f60a807b4f29baa2c10c2babc8bb', 'xmx5JLX8Oc');
INSERT INTO `order_protocol` VALUES ('532b2c8bee9845998250c7d912c9b42e', 'RrQBxopUZv');
INSERT INTO `order_protocol` VALUES ('53929cec59ba4a9b889618ee3664f8c2', 'ng7pQBNbVy');
INSERT INTO `order_protocol` VALUES ('541dcd05068a486aa2873cf569124904', 'ix0iAF8Mxb');
INSERT INTO `order_protocol` VALUES ('5459a07fb1aa4a83a5fddd28065d026e', 'F7v6fQ0333');
INSERT INTO `order_protocol` VALUES ('54a69675a3e1487cbe6068b5cb9bc55d', 'xmvDnSlTT4');
INSERT INTO `order_protocol` VALUES ('5662dcc0bd4d4a0ba187a35fc7791519', 'DZYhByIMRz');
INSERT INTO `order_protocol` VALUES ('5680222b45db4eeca6476cd03a80f533', 'cj8OdzCAJy');
INSERT INTO `order_protocol` VALUES ('5a5e5d305e274eb9beb2129c46c769a3', '0AInxYkVKi');
INSERT INTO `order_protocol` VALUES ('5b572dca21434c51b3dd1b383086f63a', 'IJ2YXCO9Ag');
INSERT INTO `order_protocol` VALUES ('5bd824b2e17e4832be43354ac2461a61', 'jiIbSNZrel');
INSERT INTO `order_protocol` VALUES ('5c38af7999504db28064de0300162ace', 'qQa3cVIwp0');
INSERT INTO `order_protocol` VALUES ('5c3c347bdc1343f89bb770841039dd83', 'zX6znox0dv');
INSERT INTO `order_protocol` VALUES ('5d01ec525b844e4989b88843aae3b7c7', 'rm8BsjG3qy');
INSERT INTO `order_protocol` VALUES ('5d7b5db4235245b799a18d31a339e44c', 'qHeWaYfBvH');
INSERT INTO `order_protocol` VALUES ('5e8143e094c84029bec609adba115be7', 'DlzdCZ2vGh');
INSERT INTO `order_protocol` VALUES ('6244a9feac4849ed9e0ea4d3c7bfc53a', 'F0cKUROFwp');
INSERT INTO `order_protocol` VALUES ('6274f6f5a3864d038ce0b16a64c65d80', '6EIOiv4w8X');
INSERT INTO `order_protocol` VALUES ('630c8a97244b4a068c12ecd839ed44bf', 'mqz01n1eOB');
INSERT INTO `order_protocol` VALUES ('63aa8731b2f84d95a34da03d447f3f00', 'JTpN9FkjXa');
INSERT INTO `order_protocol` VALUES ('66bdac70f07a44619f71c13af834175d', 'boTDNPO65i');
INSERT INTO `order_protocol` VALUES ('66bdd5a5f1df40e58b3868787edba38b', 'LTqxrPAiJG');
INSERT INTO `order_protocol` VALUES ('66c7d54f37cc4464966d6845961048f9', 'zfAnHoVMGx');
INSERT INTO `order_protocol` VALUES ('671dae48c86645e5a9b6f325f8e4631d', 'qBlnqVcjuX');
INSERT INTO `order_protocol` VALUES ('694a4f00f5a54c8babbb5cafe16b560c', 'mG9aofbX9c');
INSERT INTO `order_protocol` VALUES ('6ba045ae801e40689959d227f8815cf5', 'MzldGLkJI8');
INSERT INTO `order_protocol` VALUES ('6bd75ed3c1cb446e8c235764a660d70f', 'XCtfpMcwr1');
INSERT INTO `order_protocol` VALUES ('6e5468c8fe11498ba393e25eb211d383', 'b9chYQKCZ0');
INSERT INTO `order_protocol` VALUES ('6eda7a156d5f45f1ade649739fd75020', 'rnSVk5tfgw');
INSERT INTO `order_protocol` VALUES ('7094549e2b9b4f43a6fceaadce857122', 'xnOwu07ibB');
INSERT INTO `order_protocol` VALUES ('70ca6235735540758efe7f2929905c8d', 'cLq0EvVHKD');
INSERT INTO `order_protocol` VALUES ('71e5859d42564937b2d13c497499472a', 'ZvOw61JOTb');
INSERT INTO `order_protocol` VALUES ('728d92a35f3945e99c72d1acfdac442d', 'iE11KpfDUk');
INSERT INTO `order_protocol` VALUES ('735b44c56ea643af9db57ed2a42ccc54', 'wmv8S0cxUM');
INSERT INTO `order_protocol` VALUES ('7415c6d6dc7b4152831fb57d1b881d57', 'Jg0NfE31QV');
INSERT INTO `order_protocol` VALUES ('747391427937485288980c7cead16049', 'kE6Thk2ucK');
INSERT INTO `order_protocol` VALUES ('748535e56da3489198f8eeeaceb4361e', '9GxTyT0ugf');
INSERT INTO `order_protocol` VALUES ('7640d5ebcf0c4e79a1121847524b1056', '5HPVtRvy0e');
INSERT INTO `order_protocol` VALUES ('76b972239e1941c895e189c303bdde1b', 'c4yq1szd05');
INSERT INTO `order_protocol` VALUES ('79a5ff65a7ec437c8b170c47fd4124ac', 'mPxQx26A1O');
INSERT INTO `order_protocol` VALUES ('7ac4492e01d84344a635af0d272f7eca', '7CERSg3JJ1');
INSERT INTO `order_protocol` VALUES ('7b15486f43d84b1c8c6ecbcc462633a0', 'eIK1QNyxS1');
INSERT INTO `order_protocol` VALUES ('7bf13efe0f8e45d5b26b0d1bbb840210', 'oF2hKVWU5J');
INSERT INTO `order_protocol` VALUES ('7bfbb849337246c1b3f81f38b3bebb3b', 'HKgIIIhWM5');
INSERT INTO `order_protocol` VALUES ('7e4e4d0be94249d086f46e903c813711', 'UkPZEj5myL');
INSERT INTO `order_protocol` VALUES ('7fd572283164424d9b81f315df045ecf', 'oM4YHb97fE');
INSERT INTO `order_protocol` VALUES ('805d2643197b4623bc19badb87fecc66', 'bXBfVqiEP5');
INSERT INTO `order_protocol` VALUES ('83efad6350464a6db1d9f819cca3ad2d', 'lrhKsG3DvT');
INSERT INTO `order_protocol` VALUES ('840a96ab0f9a4d25b3eb87e9a56ab26d', 'Qa6CIMuRS0');
INSERT INTO `order_protocol` VALUES ('8613e3cfc2cb498eb1a024db8b62aad3', 'BLvHhEzjzB');
INSERT INTO `order_protocol` VALUES ('861b5d71f0c34dde947d4fb5eb48505c', 'hk2Hht6dx7');
INSERT INTO `order_protocol` VALUES ('864a5d5f98954083ab2c0a3aeda71c95', '313RCDfIUU');
INSERT INTO `order_protocol` VALUES ('87396aa590574275a64b94d99b754863', 'hNPxOsaxQn');
INSERT INTO `order_protocol` VALUES ('87bbe46300be43c5bc1b2f8e46b293fa', 'Ph3FYLpbu1');
INSERT INTO `order_protocol` VALUES ('8863b25fefc04b9f87185cbc4a4f04e1', 'lN7BkKdW3f');
INSERT INTO `order_protocol` VALUES ('88e0d7eed17c49b599f48d63039d4716', 'qkKnXevixU');
INSERT INTO `order_protocol` VALUES ('8980f95f253d4ed3b7fdde6e4c4db7f0', 'g7lyKGm4ff');
INSERT INTO `order_protocol` VALUES ('898a61ddb9974ca89a2d6649b6f97ac5', 'bDB5ODlc8L');
INSERT INTO `order_protocol` VALUES ('89a6722200114afc824e89d0aebb4f9f', '5ujALBT7K6');
INSERT INTO `order_protocol` VALUES ('8a33c9642d88425ca5c064253d6a99a5', 'vqHBd7h9Gh');
INSERT INTO `order_protocol` VALUES ('8bc85854498c4368a6d8e307992ce409', '5kAjD4OnIL');
INSERT INTO `order_protocol` VALUES ('8c631c2402e4490993fc63381794697f', 'jQ72uHng1n');
INSERT INTO `order_protocol` VALUES ('8d34eed9ed2f4530a79311c39d8761a9', 'BEAwUTbYKk');
INSERT INTO `order_protocol` VALUES ('8ea976d9c3b7420fbdfa8d1ee2cbb06e', 'NcNRyd4wrr');
INSERT INTO `order_protocol` VALUES ('8ebe6ff456e54595a1339e02c54a37f2', 'g5gnODuLQ0');
INSERT INTO `order_protocol` VALUES ('8f60dee1aa984df19c596251266da7b7', 'CnjDtsbfs8');
INSERT INTO `order_protocol` VALUES ('8fa7d24e87bd45f08d601b19d6a2a04b', 'qf6R0kDDYH');
INSERT INTO `order_protocol` VALUES ('91225e6ad4cb41c5961ac49cb9175482', 'UvoYxZtmPp');
INSERT INTO `order_protocol` VALUES ('91c3fa22d8b2418a9509d8edbc69713e', 'Duc3aTiZi6');
INSERT INTO `order_protocol` VALUES ('91f7f15421974156ab737d64b931682d', 'j9g8tyAy4k');
INSERT INTO `order_protocol` VALUES ('926491653f154c02ad93a69275bd2959', '0bTUpoca3u');
INSERT INTO `order_protocol` VALUES ('960bcbc3c9c849df9d7a819050c5ef96', 'MA2ejP5DBl');
INSERT INTO `order_protocol` VALUES ('99d49c7ebaf5463fba2d9c1302f61480', '0AurcJDMLI');
INSERT INTO `order_protocol` VALUES ('99d6a256a0dd452dbedac4c4d8d66692', 'xnAkMCzXNU');
INSERT INTO `order_protocol` VALUES ('9a052de394d64b80bb3ca09df53606cc', '0JlAV7Pizm');
INSERT INTO `order_protocol` VALUES ('9b3f7b8969324266a0aedd7eb95ad729', 'D99i1mfW6C');
INSERT INTO `order_protocol` VALUES ('9c90f91b27bb4d77b0368e89a727ebf5', '5lBVlSXtga');
INSERT INTO `order_protocol` VALUES ('9e05cead34d84a4d9f630b936b751229', 'nkLISeMXGO');
INSERT INTO `order_protocol` VALUES ('9e08ff464f9a457c8b30f9ad11417090', 'izC3cxYAzI');
INSERT INTO `order_protocol` VALUES ('9e3e098ebfef4548bae6d69f22942677', 'VMxN7h7aIz');
INSERT INTO `order_protocol` VALUES ('9ec6010185d44332b41daeca70cc8bc5', 'tKYCFtWbRY');
INSERT INTO `order_protocol` VALUES ('a0a3923d3e9e4936ac4f3ce801113464', 'hRZnQGZGJN');
INSERT INTO `order_protocol` VALUES ('a1c3b52b96c74f61b929c4c81aeb142f', 'xE9jNePP8i');
INSERT INTO `order_protocol` VALUES ('a257c8555e634d7fbd44cb676f93beb1', 'qtzwuJLm7K');
INSERT INTO `order_protocol` VALUES ('a26607ace46e4deb948305df5124f29c', 'CYoRHBA1Hl');
INSERT INTO `order_protocol` VALUES ('a5997bcbb9a04e6db1e2f0b698eb665c', '8RZIjGjUwO');
INSERT INTO `order_protocol` VALUES ('a67272f05db549cda51a87e850292c74', 's6ylMJNLcM');
INSERT INTO `order_protocol` VALUES ('a71d45bafd5646d18c2c5280d76b94f5', '9YGGCZI03l');
INSERT INTO `order_protocol` VALUES ('a99d3c0ec5714e37a4b02fb7e4b0c824', 'EV6RZN8hFe');
INSERT INTO `order_protocol` VALUES ('ab8f51033c3c4a36b9a5540f104acd8b', '4jTyI44Af5');
INSERT INTO `order_protocol` VALUES ('acfbabc1732b49579bc16de67f3b25de', '8TVYToHexS');
INSERT INTO `order_protocol` VALUES ('ad3abe55689a438a8ebadab583f3ba62', 'wJzbFoRbG1');
INSERT INTO `order_protocol` VALUES ('ae46f1dc8ae94ae2a68b1ccbecdb5654', 'EKhTgumwdR');
INSERT INTO `order_protocol` VALUES ('aeb72d0efee145388cb24af5fa02741f', 'v5xBau0K4I');
INSERT INTO `order_protocol` VALUES ('affd416db79d4275bdbd3f0e5495e781', 'DeFuqXvbQJ');
INSERT INTO `order_protocol` VALUES ('b07e1f2c5a494438a06c779b8c477a2b', 'd41sS9rjob');
INSERT INTO `order_protocol` VALUES ('b173fee89e34489eac5235c0a3ec643a', 'WxowuI3U4Q');
INSERT INTO `order_protocol` VALUES ('b241f67e747e4dd7bb8cf8636dd19a6f', 'kU4rw54vbQ');
INSERT INTO `order_protocol` VALUES ('b62e5a96b8644fc688e92d2f2410daa9', 'YlTDe2dDxb');
INSERT INTO `order_protocol` VALUES ('b72bdc1f351c4efd8eb754270ae75968', 'z0MdFsTgrW');
INSERT INTO `order_protocol` VALUES ('b92b35506af84099b1d6789b13a4b382', 'z5jVMiH0dz');
INSERT INTO `order_protocol` VALUES ('b94a1a1fb72248a1a6ea9e9b59ab1b6c', 'tE0Woaps5E');
INSERT INTO `order_protocol` VALUES ('bb32f4e5b6e84dd3a7b347658a189a12', '2wSMHMzjyu');
INSERT INTO `order_protocol` VALUES ('bbd6f57a4c0b48ea81646917886fce3e', 'oHBQVsXGzO');
INSERT INTO `order_protocol` VALUES ('bc1d30d3978642fba1977b7117f51621', 'APgOK2AoIQ');
INSERT INTO `order_protocol` VALUES ('bce7b2568cb64dd3912a46111f423ed0', 'LMLGjaJ68u');
INSERT INTO `order_protocol` VALUES ('be85d8f56c7f4a8c85d53053c5872acc', 'GI3vtz27bD');
INSERT INTO `order_protocol` VALUES ('bf69479377f8424c8c980cabd476dd63', 'CmGq5FXPqs');
INSERT INTO `order_protocol` VALUES ('bffaef001d4e453a9ddb2cd0a3e9e841', 'ifiuVLnIpR');
INSERT INTO `order_protocol` VALUES ('c206ba0d19f74c43a4440646cca4c9eb', 'btBVYzw7Pe');
INSERT INTO `order_protocol` VALUES ('c2ffa85cda374cab86b0d583c933ee18', '9IA9mXHHlY');
INSERT INTO `order_protocol` VALUES ('c4d19ca9278e481eabea133feb069ab0', 'qSxF7bPBwg');
INSERT INTO `order_protocol` VALUES ('c5f934c815364b9cb8689472aa2391b1', '1JDuAmybby');
INSERT INTO `order_protocol` VALUES ('c74f63c90b7749fb91c935a9f6268062', 'MKHnmhFGzj');
INSERT INTO `order_protocol` VALUES ('c7f04932dde74b328dbf4dc41a2f7409', 'Hd7D7mlf8J');
INSERT INTO `order_protocol` VALUES ('c81b5a8a0e88471a8799f3598d470b60', 'tzDDnA6ZoI');
INSERT INTO `order_protocol` VALUES ('cb52ad77da9e4cbd8f4c8618287bd920', 'lseEGXxy1d');
INSERT INTO `order_protocol` VALUES ('cc129f5f8d7847c2a4b09daafc3603ce', 'aWGyCdGLar');
INSERT INTO `order_protocol` VALUES ('cc5da616f97a46798ebf5ace0945d20d', 'PIgYJl8o2o');
INSERT INTO `order_protocol` VALUES ('cd1a777621c1418aae17f48d94c7bb61', 'NpXQWRgh85');
INSERT INTO `order_protocol` VALUES ('cea0039b24154b7caf48b9305de1ca34', 'oruH38j7EO');
INSERT INTO `order_protocol` VALUES ('ceea4b09b5644d0296a96e85082cde09', 'TkHMph0xtU');
INSERT INTO `order_protocol` VALUES ('d2a3e3af85e94bee99968bb1b6243869', 'GrGEvu8w4E');
INSERT INTO `order_protocol` VALUES ('d3360ed196bc43ae9ae72ea951c5c2e9', 'dn9bhE6rfn');
INSERT INTO `order_protocol` VALUES ('d444fc00dded4e4d89a956f9262a6d46', '6EY1C070ha');
INSERT INTO `order_protocol` VALUES ('d563dc029e7d4eda972c03f994f67247', 'GLlZEDFD53');
INSERT INTO `order_protocol` VALUES ('d752bf3d39d2409286045035a255ddd4', 'B9AhYuONsU');
INSERT INTO `order_protocol` VALUES ('d9b0e775e6764833b6879941f6eee739', 'N8KQzL1VZd');
INSERT INTO `order_protocol` VALUES ('da5c6051eaf342d5aab7d6dc0d3195aa', 'M3bR5Fc0SH');
INSERT INTO `order_protocol` VALUES ('da73b76b675447f2a8c44b1f23c304b7', '2qiwXAI2Mv');
INSERT INTO `order_protocol` VALUES ('db0501f4f2604beaada3e9f134e1258c', 'Js8rNBVLwi');
INSERT INTO `order_protocol` VALUES ('db2713ed189a48c4ba196b20b626ab18', 'o2EvyXHuOo');
INSERT INTO `order_protocol` VALUES ('db49b667359042ffb689bc02dedbddea', 'JitGBjumBH');
INSERT INTO `order_protocol` VALUES ('db8904e4137a42aabe46f197d9de955f', 'x9D1j3T4gW');
INSERT INTO `order_protocol` VALUES ('dba958d6e0d0487a98a98e5b99a1ff4d', 'BW7WLisPVR');
INSERT INTO `order_protocol` VALUES ('dd5ff855f80e4f06b17daa98e05e2b4d', 'gD0WFQlYpl');
INSERT INTO `order_protocol` VALUES ('dd6fc7a78d0f4ed5956f4a747f00c4ce', 'UFySzvdX9l');
INSERT INTO `order_protocol` VALUES ('deb17c622f2d43cc9a38c8fc9c24ce3c', 'rENUO9a3Cx');
INSERT INTO `order_protocol` VALUES ('e17c32efd4ed4cbda35f7970e0171949', '3xYPaOSa26');
INSERT INTO `order_protocol` VALUES ('e1e9d15574b14c5ab10a9173af542c73', '1u11hPBTIT');
INSERT INTO `order_protocol` VALUES ('e3e031e014a8496d83b6d25c0f1f43b6', 'apziRJqZXZ');
INSERT INTO `order_protocol` VALUES ('e4285e6e474e4081a8cc646086e4125f', '89LWIGt07d');
INSERT INTO `order_protocol` VALUES ('e4932f633a494a7cb368dc439c727837', '4RWpziVtER');
INSERT INTO `order_protocol` VALUES ('e5c1a1bc92ad4fb0837adaec5ca628f2', 'nEFnsRujvZ');
INSERT INTO `order_protocol` VALUES ('e64df120b1b74d5a8efe89076d7f769e', 'BUQNhCtW7c');
INSERT INTO `order_protocol` VALUES ('e6ef1bde7ffc4f1a905560a77af11f26', 'v0IvEHF16E');
INSERT INTO `order_protocol` VALUES ('e7a30756159a4c489c30aaaf5328cbd3', 'yewXg2bWSf');
INSERT INTO `order_protocol` VALUES ('e8659fe43f87452d8a5878a712d6dc15', 'LVZDqmObMl');
INSERT INTO `order_protocol` VALUES ('e89991f37f6942108971e817ed02fa01', 'beaI7FhVrr');
INSERT INTO `order_protocol` VALUES ('e959d5d7805c40c8b39062f51d996f60', 'p1iv4fc5PU');
INSERT INTO `order_protocol` VALUES ('e95c3ff97104449ab01b28e8b7eb27e8', 'loQJmVqH3V');
INSERT INTO `order_protocol` VALUES ('e9c95882d301453f90d7b227d07d2a35', 'ApHnQE3j2O');
INSERT INTO `order_protocol` VALUES ('eaaacdc7ded447569908999f5edf60d9', 'T7PoEgwj4Z');
INSERT INTO `order_protocol` VALUES ('eab6bf4760294856ac9c0ccc33e48e71', 'cY1Miw1Bq9');
INSERT INTO `order_protocol` VALUES ('eb12662ab7434b9cb5732d52447774a7', '1PVjqHB1GU');
INSERT INTO `order_protocol` VALUES ('ef9eeaf0024b4bf48982fa9419a7e3aa', 'k6bqnGOVbV');
INSERT INTO `order_protocol` VALUES ('f0820cb0fddb4cad8b38f669179a1333', '4xT7Ihdmz5');
INSERT INTO `order_protocol` VALUES ('f239a049c7724a4caff76850d7cec7f2', 'lR3pnzpep6');
INSERT INTO `order_protocol` VALUES ('f24ea1a87a704e96b2654b9d7a3821ef', 'IxePohcjlL');
INSERT INTO `order_protocol` VALUES ('f2803977923d44268e62e2228427d02a', 'I6jLz4IuAU');
INSERT INTO `order_protocol` VALUES ('f2c6a6d693344a5494e4473fb9e6de9d', 'UrIpDjOb3X');
INSERT INTO `order_protocol` VALUES ('f2f8346120be48a58756d1607b8f8148', 'jqncQpOrGi');
INSERT INTO `order_protocol` VALUES ('f31c8254314a44999f5cc93b269c26ce', 'VXFzQCeEeu');
INSERT INTO `order_protocol` VALUES ('f3785a08ac5a40bfb37f1afd15e81a2c', 'XZw7I7eLZn');
INSERT INTO `order_protocol` VALUES ('f3c45908fabe4bcca37dc6b936ae5a8d', '5QFa8Xbus5');
INSERT INTO `order_protocol` VALUES ('f40321cd86a144e48b1dff10d29a5ceb', 'njPpEH0IIM');
INSERT INTO `order_protocol` VALUES ('f41065b1d7dc41618073a7e9594bd88e', '3nGolO1cc4');
INSERT INTO `order_protocol` VALUES ('f4f1a623a6704467ace16e890cf427da', 'Sm4h1xONvC');
INSERT INTO `order_protocol` VALUES ('f62cd6f086364b089e15158258f61ccd', 'FyL9sd3pdQ');
INSERT INTO `order_protocol` VALUES ('f682296631364c3095c36cb5cd075fff', '8V0JTo2xTL');
INSERT INTO `order_protocol` VALUES ('f89b1b094b114811992e9657c43481c3', 'tutOEZ56Hk');
INSERT INTO `order_protocol` VALUES ('f9ca70e5fa2346628b468ab7d65f6d2c', '9KF4lv154Z');
INSERT INTO `order_protocol` VALUES ('fcb6f2f0fe784bae9db5ae706bcb8587', 'CVPDoFko8Q');
INSERT INTO `order_protocol` VALUES ('fdb563baaf554c64b86a878344c6c27d', 'w4e7yeZuYB');
INSERT INTO `order_protocol` VALUES ('fe5fbeed67054f6fb3f0eadeb3cdfa43', 'JtoVPq1ke2');
INSERT INTO `order_protocol` VALUES ('fe9c567aba1b48bf9331aa6bdd17a4c9', 'k3EzFjwcPE');
INSERT INTO `order_protocol` VALUES ('febc86c69e9d4c90b5c4918165847534', 'XhiYVVbhBt');
INSERT INTO `order_protocol` VALUES ('ff1f43a664ce483a93c257bca52d65af', 'kA97c7alBE');

-- ----------------------------
-- Table structure for order_uncompleted_order0
-- ----------------------------
DROP TABLE IF EXISTS `order_uncompleted_order0`;
CREATE TABLE `order_uncompleted_order0`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `order_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `amount` decimal(10, 4) NULL DEFAULT NULL COMMENT '价格',
  `pay_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付状态',
  `order_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `payment_times` int(11) NULL DEFAULT NULL COMMENT '支付次数',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_uncompleted_order0
-- ----------------------------
INSERT INTO `order_uncompleted_order0` VALUES ('04624e86d6f14328becbf62944fd56b3', '0b4c37d9962a4a7384d059dc3f32d5da', '335027663150252032', '红塔山', 27.0000, '0001', 'STOP', 0, '2007-10-11 16:23:19', '2013-08-24 15:50:19');
INSERT INTO `order_uncompleted_order0` VALUES ('04d43a1d6c854acca98938520503a07f', '96fca7f5e4124f29b3d6237e9dbb3fcf', '335027802476642304', '小熊猫', 28.0000, '0003', 'CLOSE', 1, '2003-02-26 20:41:53', '2009-04-11 13:12:53');
INSERT INTO `order_uncompleted_order0` VALUES ('056426883b3149f2b7b1660c8765483d', 'eeef756d2ef442248c5f6e0f11cb2bbd', '335027803722350592', '小熊猫', 16.0000, '0001', 'UN_KNOW', 6, '1998-04-10 05:01:53', '2009-04-10 07:44:53');
INSERT INTO `order_uncompleted_order0` VALUES ('0600b0fdc09e45f6920110fef44bcd59', '3c00c9792ac84e18885087e78258a42e', '335027804720594944', '利群', 6.0000, '0002', 'CLOSE', 7, '1995-10-27 04:29:53', '2006-11-13 17:32:53');
INSERT INTO `order_uncompleted_order0` VALUES ('079b97de3e874586aaba958b3dbfcae2', '7e5a2c1467584fc0b4a89bae9f6a9ce1', '335027662172979200', '黄鹤楼', 25.0000, '0001', 'DELAY', 9, '2011-12-12 03:40:19', '2017-04-21 11:19:19');
INSERT INTO `order_uncompleted_order0` VALUES ('0a7cc82dd39a4656946e505d968b4cac', '46045d07746140fbb6906c4f1b7f054b', '335027661975846912', '小熊猫', 12.0000, '1001', 'DELAY', 6, '1990-01-01 17:53:19', '2002-12-09 07:27:19');
INSERT INTO `order_uncompleted_order0` VALUES ('0b462f2370934d5d9c8cc952fbc97854', '705cfbfc4a7d4b9fa138cf0d87483994', '335027661866795008', '雪茄', 10.0000, '0002', 'UN_KNOW', 2, '1995-08-13 17:06:19', '2010-03-21 07:01:19');
INSERT INTO `order_uncompleted_order0` VALUES ('0d67b20981b141bf907c7266451bb70b', 'f8045541c9ba4617bd45916733225ac0', '335027802942210048', '雪茄', 14.0000, '0001', 'STOP', 5, '1994-04-10 22:56:53', '2009-04-11 19:32:53');
INSERT INTO `order_uncompleted_order0` VALUES ('0d8fe29fb620473cbbc667eb5d1849d7', '40ca14ba7e11438cae54f825b7fc3478', '335027804502491136', '黄鹤楼', 14.0000, '0002', 'OPEN', 0, '2001-02-17 02:58:53', '2010-01-07 03:01:53');
INSERT INTO `order_uncompleted_order0` VALUES ('0fa873bf535a4fc1aa06869cae1be17b', '14fc09308c5a46dfa81ea66b25092204', '335027804267610112', '黄鹤楼', 18.0000, '0001', 'CLOSE', 8, '2008-04-18 19:57:53', '2017-03-20 23:55:53');
INSERT INTO `order_uncompleted_order0` VALUES ('127707dcd5ee4cb2a8c2d56f619c482e', 'b12d8aba950d425db18b6e113901c4ea', '335027663548710912', '利群', 10.0000, '0002', 'OPEN', 9, '2002-01-05 08:30:20', '2019-03-21 09:09:20');
INSERT INTO `order_uncompleted_order0` VALUES ('1307f0d6fa3c4827971b18f32951d2fe', '416f456c9e9749b29350272daf1f0d59', '335027801163825152', '长白山', 5.0000, '0002', 'UN_KNOW', 8, '1989-08-16 10:22:52', '2008-06-22 04:41:52');
INSERT INTO `order_uncompleted_order0` VALUES ('14f6147c6c7d4ba28d004925cb2bf7a8', '5d00311f6b80475c9a850fd8e4dd95ef', '335027803613298688', '雪茄', 11.0000, '0002', 'OPEN', 0, '2000-06-09 21:12:53', '2009-04-09 01:52:53');
INSERT INTO `order_uncompleted_order0` VALUES ('151e40743121406cb30df53b6d4a17dd', '7d6fb2fcfcd840e3a8faa646d2b94ccc', '335027804368273408', '黄鹤楼', 10.0000, '0002', 'CLOSE', 1, '1994-04-05 23:09:53', '2001-01-31 10:39:53');
INSERT INTO `order_uncompleted_order0` VALUES ('15c2e72d4f804927b00506499d32d165', 'ed623ce5cd2b4dc4bff69830c107917b', '335027803307114496', '雪茄', 10.0000, '0001', 'DELAY', 8, '1994-03-06 02:30:53', '2005-12-13 04:34:53');
INSERT INTO `order_uncompleted_order0` VALUES ('17be0e90d9f0491a8e01d232092f8944', '9d450ce775e744d397a67d33f140e881', '335027662466580480', '小熊猫', 11.0000, '1001', 'UN_KNOW', 2, '1986-12-05 09:22:19', '2005-06-15 17:43:19');
INSERT INTO `order_uncompleted_order0` VALUES ('18bc1d062d2346a0ae51792fdaec97bf', '2d4417009db84caf985b23147a28490d', '335027801776193536', '芙蓉王', 9.0000, '0001', 'CLOSE', 9, '2005-04-01 01:44:52', '2008-02-04 10:32:52');
INSERT INTO `order_uncompleted_order0` VALUES ('1d849fe937304200b49bee4c14bf2e4f', '02e81396fad74307897fe8ba4e5ced50', '335027804456353792', '红塔山', 1.0000, '1001', 'STOP', 2, '2009-06-03 17:21:53', '2015-11-10 13:00:53');
INSERT INTO `order_uncompleted_order0` VALUES ('1e54ff6670134757974a9467baa6812a', 'dde992479ca2476aacab922a1df63bdf', '335027661766131712', '雪茄', 20.0000, '0001', 'CLOSE', 6, '1989-09-24 02:28:19', '2005-05-08 08:45:19');
INSERT INTO `order_uncompleted_order0` VALUES ('1ec6bfff1b0f45fba6118fd57686b977', '511ad13c555c48a79f5ccbad0b769a29', '335027801293848576', '小熊猫', 20.0000, '1001', 'DELAY', 1, '2001-12-31 19:25:52', '2002-02-08 12:31:52');
INSERT INTO `order_uncompleted_order0` VALUES ('1f3a1c8d7f144299b7176f670f131373', '3cc8d8c0ab8847668bdfa51206eada42', '335027803655241728', '利群', 4.0000, '0002', 'STOP', 1, '2007-07-16 00:41:53', '2009-01-04 08:36:53');
INSERT INTO `order_uncompleted_order0` VALUES ('23e2e312770e4f5d8fe666befae6ddca', 'c35236624c86490ea2e7ab290700adec', '335027804426993664', '利群', 10.0000, '0001', 'OPEN', 2, '2014-12-18 18:05:53', '2018-04-23 12:42:53');
INSERT INTO `order_uncompleted_order0` VALUES ('29e6c99c8c694cdb9b35cc913e5fdcc8', 'c903536099e049ccbcdea667379778a3', '335027804749955072', '利群', 8.0000, '0002', 'OPEN', 6, '1996-11-19 11:31:53', '2015-10-17 17:15:53');
INSERT INTO `order_uncompleted_order0` VALUES ('2ba01342acfd45ffa9c926ce095fb562', '1bb355b981bf4540b49045989abae0fc', '335027804657680384', '红塔山', 22.0000, '0001', 'OPEN', 6, '1994-09-25 13:33:53', '2011-04-16 12:04:53');
INSERT INTO `order_uncompleted_order0` VALUES ('3035da08136e458a914128aad8c61bfd', '8af25f6522d04f91893935b87990c3b0', '335027663217360896', '红塔山', 13.0000, '0003', 'UN_KNOW', 5, '1992-08-27 18:07:19', '2007-03-03 06:42:19');
INSERT INTO `order_uncompleted_order0` VALUES ('321f5f3bbbe34f0bbfcb66edb7f989ba', '52cf4200b5254fcaaa8f35794963a013', '335027803172896768', '小熊猫', 18.0000, '1001', 'OPEN', 1, '2006-05-12 13:53:53', '2007-08-22 09:28:53');
INSERT INTO `order_uncompleted_order0` VALUES ('3458b1d27e0c440c8277141136713a0d', 'ab6bd42f57dd4594a7995c92e12485a2', '335027803424555008', '利群', 29.0000, '1001', 'STOP', 9, '2008-12-28 13:02:53', '2014-03-17 16:01:53');
INSERT INTO `order_uncompleted_order0` VALUES ('36b7173bd2b54ced946dfdeda13a4d9c', 'af6d752754a24cdb829a2189d78012bb', '335027663175417856', '长白山', 9.0000, '0002', 'UN_KNOW', 9, '1998-11-02 21:28:19', '2015-04-06 09:18:19');
INSERT INTO `order_uncompleted_order0` VALUES ('389e1f0e538140e6941b3170470803e0', 'f2b090a733b64b9b88f241e952523ace', '335027803512635392', '红塔山', 26.0000, '0002', 'DELAY', 9, '1983-04-10 20:07:53', '2000-05-18 09:49:53');
INSERT INTO `order_uncompleted_order0` VALUES ('3c75e55fcc7d45a6a8dc10a2a6a46f44', '67cd4aeafd1144c5973328f2293d142a', '335027662391083008', '雪茄', 26.0000, '0003', 'STOP', 7, '2000-07-07 22:55:19', '2015-03-11 06:29:19');
INSERT INTO `order_uncompleted_order0` VALUES ('40e615948a044be9b566a09637f90a50', '6ed70d369b684925a2fb74fa20c5cf2e', '335027801709084672', '长白山', 2.0000, '1001', 'UN_KNOW', 0, '1995-11-28 15:04:52', '2005-11-13 06:02:52');
INSERT INTO `order_uncompleted_order0` VALUES ('42ac5b0248414697ab18017fd39515b9', '6067d33a8071402e8011b594c7eee090', '335027803118370816', '雪茄', 1.0000, '0001', 'OPEN', 3, '1995-04-01 04:49:53', '2010-10-29 19:10:53');
INSERT INTO `order_uncompleted_order0` VALUES ('47b655bce1a945b08b61b84a6ce8f354', '848947c8e69845a6bfafa0e0b4024719', '335027662642741248', '利群', 24.0000, '0003', 'CLOSE', 0, '1993-05-04 11:46:19', '2001-12-13 15:11:19');
INSERT INTO `order_uncompleted_order0` VALUES ('4c160c3663a6484b94e456913cd4dd61', 'd1442d060ba34e769ae14f55eb51a894', '335027803885928448', '芙蓉王', 20.0000, '0001', 'OPEN', 1, '2007-10-28 08:15:53', '2008-07-14 08:50:53');
INSERT INTO `order_uncompleted_order0` VALUES ('4c4c7b3fc09c47a89fb05a6a519550e6', '996897eda6014009a161316e25d572dd', '335027661233455104', '芙蓉王', 26.0000, '0002', 'UN_KNOW', 0, '1991-06-09 13:22:19', '2001-06-28 18:22:19');
INSERT INTO `order_uncompleted_order0` VALUES ('4e73f71fbb4d41789da57b579c9fef1e', 'cec9d0367958475f8f59edfedaaee712', '335027661841629184', '芙蓉王', 26.0000, '0003', 'UN_KNOW', 4, '1999-09-24 22:08:19', '2018-03-18 02:40:19');
INSERT INTO `order_uncompleted_order0` VALUES ('4f1768dc0c85497aa6a3a439aa3ff0ab', 'aa764bcd88b44054a4718974a9a89d5b', '335027804242444288', '芙蓉王', 27.0000, '0002', 'OPEN', 6, '1990-06-01 15:10:53', '2000-10-30 08:55:53');
INSERT INTO `order_uncompleted_order0` VALUES ('532921217063470da2715b41c862d05a', '78673aff807d45c3a79d0d66bb933728', '335027804477325312', '长白山', 29.0000, '0001', 'STOP', 5, '2007-07-21 18:19:53', '2012-02-06 06:20:53');
INSERT INTO `order_uncompleted_order0` VALUES ('546048fafb654335a400fa3abf02ba2e', '1ab79c1dc7134909a6b083ace3e173b4', '335027660583337984', '利群', 28.0000, '1001', 'CLOSE', 0, '2004-04-29 20:57:19', '2010-06-27 13:50:19');
INSERT INTO `order_uncompleted_order0` VALUES ('59b52cfd050d49dd832ac9ae4bd61b06', 'ae098e4c88e14b6a83e7937581b6c466', '335027803583938560', '芙蓉王', 23.0000, '0003', 'DELAY', 6, '1994-07-24 08:40:53', '2012-04-15 02:17:53');
INSERT INTO `order_uncompleted_order0` VALUES ('5b148e81470442239688370d938763ae', '8aee376e0c884b0388064244faf00ebc', '335027661791297536', '红塔山', 5.0000, '0002', 'UN_KNOW', 8, '2000-04-18 01:11:19', '2015-11-25 11:48:19');
INSERT INTO `order_uncompleted_order0` VALUES ('5c950a24a95e472ebdb5fa1741fe9dfb', '0eab0ca83f914a559970d4511bba5920', '335027663485796352', '利群', 15.0000, '0001', 'CLOSE', 3, '2004-01-18 17:08:19', '2006-08-25 20:56:19');
INSERT INTO `order_uncompleted_order0` VALUES ('618622e93cb54b2a9c85dd79c193ec83', 'acc0f7d6a0c441ba8828757444a17402', '335027661736771584', '利群', 5.0000, '0003', 'UN_KNOW', 8, '2006-10-16 09:13:19', '2016-10-13 20:03:19');
INSERT INTO `order_uncompleted_order0` VALUES ('6763414b3e7d45d789f0f5a9d2641fda', 'fb50e926388645629a77e253fc2c5c5e', '335027662420443136', '利群', 12.0000, '1001', 'DELAY', 7, '1992-01-28 15:16:19', '2005-08-25 22:01:19');
INSERT INTO `order_uncompleted_order0` VALUES ('67deaa5f7d2d458bbba61bbdef714ec5', '3933fe1a00d74a43a10a941560f39c1a', '335027663464824832', '芙蓉王', 9.0000, '0001', 'CLOSE', 0, '2009-12-13 18:36:19', '2015-04-05 19:46:19');
INSERT INTO `order_uncompleted_order0` VALUES ('6affa4f6131444bb829830c4c3082a51', '6b87c7e38fc3409e87a56d586d18d72a', '335027802065600512', '利群', 28.0000, '0002', 'STOP', 7, '1992-05-05 00:26:53', '2007-06-05 04:14:53');
INSERT INTO `order_uncompleted_order0` VALUES ('6df0d814cf91446dac041e6ad9add6e6', 'ef99888dce7848739a8d8cc2c341dc83', '335027803491663872', '雪茄', 5.0000, '1001', 'DELAY', 4, '1986-09-03 06:59:53', '2005-03-26 16:19:53');
INSERT INTO `order_uncompleted_order0` VALUES ('75d90fbd311742d0baa02074c683f588', '766316f18fd04932b213dc5a411a55d7', '335027663271886848', '黄鹤楼', 24.0000, '0001', 'UN_KNOW', 0, '1995-08-19 05:11:19', '2005-09-05 02:41:19');
INSERT INTO `order_uncompleted_order0` VALUES ('7986f4bc44fb444f992db21667861153', '6d8417ce837646c6ba04770c34bf16de', '335027662760181760', '雪茄', 13.0000, '0003', 'STOP', 1, '2003-03-28 00:07:19', '2004-09-11 12:56:19');
INSERT INTO `order_uncompleted_order0` VALUES ('7abd6e15ece14c33948569e5e5bb9a0e', 'b1fee94424ff407a8be9e8e5285d4f3d', '335027662730821632', '雪茄', 14.0000, '0001', 'STOP', 7, '2003-01-07 15:37:19', '2012-07-17 03:34:19');
INSERT INTO `order_uncompleted_order0` VALUES ('7c5d2c02e79a490c86d29db5587c4718', '9ca7753b6ca249e299e32956a670994d', '335027802656997376', '长白山', 19.0000, '1001', 'OPEN', 1, '2017-07-14 13:30:53', '2018-12-18 13:09:53');
INSERT INTO `order_uncompleted_order0` VALUES ('8b887ec249b24e7697c415dd8639c637', '8909d8950efa4874812fea456b238a22', '335027803751710720', '利群', 7.0000, '1001', 'STOP', 2, '1996-10-21 17:30:53', '2014-12-30 14:07:53');
INSERT INTO `order_uncompleted_order0` VALUES ('9179ced8584942c7be4a81348ab5052c', '3cd3da83b7ba42809ee447993141bbc3', '335027663355772928', '小熊猫', 6.0000, '0003', 'OPEN', 5, '2005-09-18 04:49:19', '2015-11-01 22:28:19');
INSERT INTO `order_uncompleted_order0` VALUES ('91bf0a6b6fe5451a8df224ea32fda652', '790fce5ce0324fb68241de2beaba9e81', '335027661682245632', '黄鹤楼', 1.0000, '0003', 'OPEN', 9, '2001-07-06 17:57:19', '2010-09-22 19:34:19');
INSERT INTO `order_uncompleted_order0` VALUES ('933481743b7d426b82aceab32ad21322', '717b0b724bf84d7787d0b46ee48a1cf3', '335027662533689344', '红塔山', 14.0000, '0003', 'STOP', 6, '2013-11-13 07:25:19', '2015-04-02 08:25:19');
INSERT INTO `order_uncompleted_order0` VALUES ('938b7ee13e23403da0b31fd07c056f9f', '30e59b9ff66642869be4ad3245df9b59', '335027663439659008', '红塔山', 24.0000, '1001', 'DELAY', 3, '2001-07-27 02:02:19', '2005-04-20 12:03:19');
INSERT INTO `order_uncompleted_order0` VALUES ('9999f8af48bb422aaed6c9e6073fb32e', '6322ea9c8c8a413d87c47005fa128abe', '335027803634270208', '小熊猫', 9.0000, '0002', 'UN_KNOW', 6, '1997-06-04 17:53:53', '2004-05-04 10:04:53');
INSERT INTO `order_uncompleted_order0` VALUES ('9a857ff42fe242779c94b60f45f628ef', 'c7faa1a47b4f4299a4448a8a75201e0d', '335027803537801216', '利群', 12.0000, '0002', 'CLOSE', 1, '2010-11-25 23:47:53', '2015-01-22 01:28:53');
INSERT INTO `order_uncompleted_order0` VALUES ('9bc899b980a34a108735ba729314fb95', 'a221fcefa5f940e0a2f6d0188d843cf3', '335027663196389376', '黄鹤楼', 18.0000, '0001', 'OPEN', 9, '1997-07-18 05:53:19', '2006-02-15 18:34:19');
INSERT INTO `order_uncompleted_order0` VALUES ('9c958d2b16a548f78737a47bbb5d69ba', '81db3b02ee3e402a8f0725f69e0c355b', '335027803852374016', '利群', 7.0000, '0003', 'CLOSE', 9, '2000-08-01 02:15:53', '2007-05-09 01:51:53');
INSERT INTO `order_uncompleted_order0` VALUES ('9f47fb7923b54674ade9535f53a77c3a', 'f990caf2dabb4863abcf0a94ae180f6a', '335027803776876544', '芙蓉王', 5.0000, '0002', 'CLOSE', 3, '1993-11-24 18:42:53', '2005-05-19 10:32:53');
INSERT INTO `order_uncompleted_order0` VALUES ('a16db784eaec46f9a9d2f1743aae5826', '8698f98790164ecab4f438eaa0cba04b', '335027663380938752', '利群', 22.0000, '0001', 'DELAY', 9, '2007-04-14 23:48:19', '2008-01-31 20:38:19');
INSERT INTO `order_uncompleted_order0` VALUES ('a4a6d47034c94125accd6b599ec4bfaa', 'cdd27686a275496181f467f96208a6bf', '335027802703134720', '红塔山', 11.0000, '0001', 'DELAY', 5, '1995-01-28 00:30:53', '2003-06-10 03:30:53');
INSERT INTO `order_uncompleted_order0` VALUES ('a4e90413133d49b7a0f699386c3f820f', '03a0893135db4e20b3d4944e63bd2957', '335027663523545088', '红塔山', 22.0000, '0001', 'STOP', 1, '1987-11-30 06:28:19', '2000-06-10 05:27:19');
INSERT INTO `order_uncompleted_order0` VALUES ('a5e5210308d144afa505b924befe3ad3', '22ec17583f104560a5981d3943c20772', '335027662667907072', '雪茄', 0.0000, '0003', 'DELAY', 1, '2007-04-25 02:01:19', '2016-06-23 19:09:19');
INSERT INTO `order_uncompleted_order0` VALUES ('a6f048cba9134864bfadb53c801dcf1c', '7630e00087fb45fc8a85fb95a6fd1f88', '335027801595838464', '红塔山', 5.0000, '0001', 'CLOSE', 7, '1997-09-30 17:08:52', '2002-03-12 07:10:52');
INSERT INTO `order_uncompleted_order0` VALUES ('a94f8b1459c94783bcce2dc08d4ef325', '587731c7781f4d5cb727f9325195b9a6', '335027804598960128', '利群', 9.0000, '0003', 'DELAY', 4, '1990-08-05 14:57:53', '2007-08-05 13:17:53');
INSERT INTO `order_uncompleted_order0` VALUES ('abd895ad72bb479fad5b99ba6bbbd815', 'f26a2acff1ce482a966080304d548fa0', '335027804577988608', '长白山', 27.0000, '0002', 'STOP', 1, '2006-02-03 01:58:53', '2015-07-29 12:08:53');
INSERT INTO `order_uncompleted_order0` VALUES ('adb01a142ea948188aae103072badffe', '949c9d2485e9469e921ea1e5a2c53d33', '335027803235811328', '长白山', 1.0000, '0001', 'CLOSE', 7, '1997-05-05 16:12:53', '2011-01-19 18:35:53');
INSERT INTO `order_uncompleted_order0` VALUES ('addd09a27e664f92aadbaae7f573eb1f', 'f5731579e02b48bd827d1f239567d4e4', '335027662445608960', '小熊猫', 29.0000, '0003', 'DELAY', 5, '2007-04-18 12:56:19', '2015-07-10 09:18:19');
INSERT INTO `order_uncompleted_order0` VALUES ('ae1ac5c5bc0e4cb78920c6e7598897fe', 'd8107e3e4ba84eff92d70d6fbfc6159d', '335027662508523520', '长白山', 10.0000, '0001', 'CLOSE', 1, '2017-08-31 12:15:19', '2019-02-26 20:39:19');
INSERT INTO `order_uncompleted_order0` VALUES ('aef6508665ad41ddabe72ee1fc00bc6d', '8a6eb791b1b745bba893a16b98338822', '335027661950681088', '小熊猫', 11.0000, '1001', 'OPEN', 0, '1989-01-26 08:46:19', '2002-09-08 16:42:19');
INSERT INTO `order_uncompleted_order0` VALUES ('b101a3f8e07b4025b900859f426e67f5', 'fa8e2a23aab7415d975a1fb8d34be1e7', '335027662558855168', '红塔山', 8.0000, '0002', 'DELAY', 6, '1985-03-18 19:12:19', '2001-03-27 21:33:19');
INSERT INTO `order_uncompleted_order0` VALUES ('b1e648af2fb94872b76aa64e625b65e3', 'e8526ff424294ff29ae301892841f7ec', '335027661350895616', '芙蓉王', 8.0000, '0001', 'STOP', 7, '2007-11-28 23:01:19', '2018-04-06 22:22:19');
INSERT INTO `order_uncompleted_order0` VALUES ('b814f7e721d247cd8212e12b05d879f0', '675dd40cce034bb1ab8562a3fdcbed15', '335027804548628480', '小熊猫', 24.0000, '0003', 'DELAY', 1, '2004-03-15 10:53:53', '2010-12-23 03:02:53');
INSERT INTO `order_uncompleted_order0` VALUES ('b88a5fe55299479c8e4ab4bd950fc81d', 'e9db3e2c0572465fa1f62053e745e5ad', '335027803059650560', '雪茄', 2.0000, '0002', 'STOP', 5, '1997-03-30 09:10:53', '2009-09-09 12:45:53');
INSERT INTO `order_uncompleted_order0` VALUES ('b89e581d5f244c9cb119fd0a56cb45e4', '48d2bf0638ef402699cb55210e652959', '335027802812186624', '利群', 3.0000, '1001', 'OPEN', 6, '2000-06-17 23:34:53', '2006-02-04 20:19:53');
INSERT INTO `order_uncompleted_order0` VALUES ('b8a4aff44cee43f7b87667836ae0cd2f', '568608b1761e4b52b5eadf939403ce32', '335027803697184768', '雪茄', 29.0000, '1001', 'STOP', 5, '1994-06-26 04:27:53', '2000-10-23 10:30:53');
INSERT INTO `order_uncompleted_order0` VALUES ('b8a74a889b364e688ef05eae965969b0', '62c3c964b0d84c4dabdf991db5358d6f', '335027804523462656', '黄鹤楼', 4.0000, '1001', 'CLOSE', 7, '2002-11-04 02:39:53', '2010-10-14 06:15:53');
INSERT INTO `order_uncompleted_order0` VALUES ('bd38bf679b7e4a1abe6244fdca144bfb', '2f1bb451cbad42bfa4fef99b2e63fd13', '335027661606748160', '黄鹤楼', 9.0000, '0001', 'DELAY', 6, '1991-12-07 07:21:19', '2000-12-08 12:29:19');
INSERT INTO `order_uncompleted_order0` VALUES ('bdf56aa56ac94c019e8ba839f215b49e', 'bd483a8a4b3c49e8aad3833784804bce', '335027801503563776', '芙蓉王', 17.0000, '0002', 'CLOSE', 7, '1995-04-16 21:18:52', '2008-07-27 03:27:52');
INSERT INTO `order_uncompleted_order0` VALUES ('bdff94b302f249488d65aeb3d6f0119b', '9ec829d5d93e4132b77c0565478266cd', '335027661434781696', '小熊猫', 13.0000, '0001', 'DELAY', 0, '1999-03-18 05:01:19', '2007-02-18 04:37:19');
INSERT INTO `order_uncompleted_order0` VALUES ('bf94f234fba14a1ab86e15c296686697', 'f64192a14438424ca671d86217e8f8d4', '335027804296970240', '长白山', 28.0000, '0001', 'UN_KNOW', 5, '1986-02-20 21:38:53', '2003-10-07 12:49:53');
INSERT INTO `order_uncompleted_order0` VALUES ('c23e3d8ec2604e888e73c438cd31eb5f', 'd7d99a640357488c9884988c247f5308', '335027661921320960', '小熊猫', 23.0000, '0001', 'UN_KNOW', 9, '2004-02-13 09:24:19', '2014-12-21 04:55:19');
INSERT INTO `order_uncompleted_order0` VALUES ('c416ce8d8dc04401a8ed4a1485c2bfbc', '8a4d128852614156b7d4d0e52b5ad9cf', '335027659471847424', '长白山', 15.0000, '0001', 'UN_KNOW', 4, '1996-04-19 08:45:19', '2007-09-10 12:02:19');
INSERT INTO `order_uncompleted_order0` VALUES ('c45d18d4ae46422291e417787b0a29ae', '51f232381dc1400db1f5f3b60ad99412', '335027804628320256', '红塔山', 28.0000, '0003', 'OPEN', 7, '1993-06-18 17:55:53', '2010-03-15 21:52:53');
INSERT INTO `order_uncompleted_order0` VALUES ('c6024ee201c14e3f8c8f59217a0e9d5b', '200643bbc4cd40f29966855e7fbb3d4a', '335027804397633536', '红塔山', 16.0000, '1001', 'DELAY', 0, '1996-02-27 03:24:53', '2009-03-17 08:00:53');
INSERT INTO `order_uncompleted_order0` VALUES ('c615c41f109b48afb3f31b06b908e8c7', 'ce6d1e947a394f109605a212e28fd5a0', '335027661136986112', '利群', 6.0000, '0001', 'UN_KNOW', 0, '2003-02-03 04:53:19', '2011-02-08 10:37:19');
INSERT INTO `order_uncompleted_order0` VALUES ('c682b25b9fb54b83a1a543e97f403803', '414fdf200f844492aea8a408d174ed42', '335027661636108288', '雪茄', 9.0000, '0002', 'UN_KNOW', 2, '1989-12-26 15:06:19', '2007-12-22 23:42:19');
INSERT INTO `order_uncompleted_order0` VALUES ('c68c29af12fa4075aaa0d251fa047f71', 'cbae268d54604998acd7b6934483f17f', '335027662068121600', '小熊猫', 27.0000, '0001', 'OPEN', 0, '2005-02-17 17:48:19', '2012-06-16 14:35:19');
INSERT INTO `order_uncompleted_order0` VALUES ('c6a2e29a37d94d2da6553f2cdded19e2', '62061d3f428945fda94147c0c8c2063b', '335027663238332416', '芙蓉王', 21.0000, '0002', 'OPEN', 1, '2001-04-21 03:41:19', '2003-10-09 21:37:19');
INSERT INTO `order_uncompleted_order0` VALUES ('c6b042c6f29947ae952207c8dd36886b', '005f0b0d2cf444bba6645f7dda7eabd8', '335027661522862080', '芙蓉王', 8.0000, '0002', 'STOP', 4, '2001-05-18 10:40:19', '2009-06-14 07:45:19');
INSERT INTO `order_uncompleted_order0` VALUES ('c76eb8b773014299bbaf933a0be697c4', 'a0123569d9c646be898797bfa07ec646', '335027803802042368', '小熊猫', 27.0000, '0002', 'DELAY', 0, '1985-01-09 01:53:53', '2003-12-29 13:06:53');
INSERT INTO `order_uncompleted_order0` VALUES ('c819d05816334673b946d93b5ebf3a91', '01da05af0e954a518a662edf1cedf322', '335027802766049280', '小熊猫', 6.0000, '0002', 'UN_KNOW', 6, '1999-11-10 03:01:53', '2014-06-25 12:47:53');
INSERT INTO `order_uncompleted_order0` VALUES ('c8590a2f34d642c083e6a3445b256705', '048fe9f779c24d60be78364b0a39c2c6', '335027661711605760', '芙蓉王', 11.0000, '0002', 'DELAY', 9, '1999-10-26 08:57:19', '2010-06-05 14:09:19');
INSERT INTO `order_uncompleted_order0` VALUES ('c910e9a4721446e5b055fa90b4fc66af', '6e28fd20b41e41ab99b95c3ca0c12ed7', '335027803827208192', '红塔山', 2.0000, '1001', 'DELAY', 1, '2007-02-27 17:50:53', '2017-10-17 09:50:53');
INSERT INTO `order_uncompleted_order0` VALUES ('cbd0a09196164d8290d14fb3a8bd1eea', 'cecf68dbd71249c499fb8087337c95b6', '335027802870906880', '长白山', 0.0000, '0001', 'CLOSE', 5, '1988-05-12 17:48:53', '2004-12-12 03:12:53');
INSERT INTO `order_uncompleted_order0` VALUES ('ceadb7dc38414713816ec985587b6a8b', '87ec33ccfcc04ba89bd9ada38cd9acf9', '335027662579826688', '长白山', 17.0000, '0002', 'DELAY', 2, '1989-04-17 11:17:19', '2005-10-25 10:08:19');
INSERT INTO `order_uncompleted_order0` VALUES ('d603a0a581204e28a2aba02f05f5cc7f', '33b2f3c730da4871a8f55f53092d4b1e', '335027662797930496', '芙蓉王', 0.0000, '0001', 'CLOSE', 1, '2006-11-27 14:50:19', '2011-12-12 17:29:19');
INSERT INTO `order_uncompleted_order0` VALUES ('d619292f222d430db8bc9fd43376fc4b', '1af5ae6489124bbe8bd79273f04b32f1', '335027662835679232', '雪茄', 6.0000, '0003', 'STOP', 1, '1994-02-27 18:48:19', '2012-02-28 10:07:19');
INSERT INTO `order_uncompleted_order0` VALUES ('d94c3c4de89a410183cb5a5dbf72c4ac', '89cd79890f6547658356177f0017d052', '335027662340751360', '雪茄', 3.0000, '0003', 'UN_KNOW', 8, '1997-02-12 19:30:19', '2007-07-06 14:11:19');
INSERT INTO `order_uncompleted_order0` VALUES ('da7e923204c64a98bba12de983111465', 'e297db8b503940e09ce0ff4253ac16e9', '335027803940454400', '雪茄', 6.0000, '0001', 'STOP', 2, '2000-08-02 18:36:53', '2018-02-17 14:32:53');
INSERT INTO `order_uncompleted_order0` VALUES ('dc10b8291f6348eeb5d3d0cfb6faba69', '1c8c7af3b9a34f818303fdc8970e0449', '335027803365834752', '雪茄', 2.0000, '0001', 'STOP', 0, '1990-05-15 09:32:53', '2006-02-09 22:28:53');
INSERT INTO `order_uncompleted_order0` VALUES ('dd1e8230ea2944d5a984ba9afaaea9aa', 'b05947009abb4dbcbf9ff698409eaef2', '335027661287981056', '长白山', 4.0000, '0001', 'CLOSE', 3, '2009-08-31 13:54:19', '2016-03-27 05:25:19');
INSERT INTO `order_uncompleted_order0` VALUES ('dd56f8872e784e4ca940030b6f46a917', '44758d98d69246638f9359eeebdb92de', '335027801230934016', '利群', 17.0000, '0003', 'OPEN', 7, '1993-09-29 22:56:52', '2006-10-31 20:58:52');
INSERT INTO `order_uncompleted_order0` VALUES ('def6de2028df4cb6b3201202e1cc8e67', '9704db7a47614be2a5b9a1bde5e1264f', '335027803676213248', '黄鹤楼', 3.0000, '1001', 'OPEN', 0, '2008-01-05 15:40:53', '2013-08-31 01:54:53');
INSERT INTO `order_uncompleted_order0` VALUES ('dff2085841d2426c9654dbbb40b8d194', '8b0b43dbd21f497f9fc558fadb036928', '335027662034567168', '小熊猫', 18.0000, '0001', 'DELAY', 1, '2001-11-12 02:37:19', '2015-10-28 14:51:19');
INSERT INTO `order_uncompleted_order0` VALUES ('e2cac5e0600e4fcc9e70d53ba44667ee', 'f14492d006be42d1856daff35915947c', '335027663301246976', '黄鹤楼', 8.0000, '0001', 'OPEN', 7, '1986-07-14 10:49:19', '2004-01-03 19:50:19');
INSERT INTO `order_uncompleted_order0` VALUES ('e419ae919a5b465c8c640094ed87b499', '645c736162394a31a93150fa514ef889', '335027803340668928', '长白山', 14.0000, '0001', 'DELAY', 0, '1998-05-11 20:08:53', '2013-08-19 14:47:53');
INSERT INTO `order_uncompleted_order0` VALUES ('e4577c3e012a458d8db5fcf66e7cb6fe', '81d70660136f4a279505bfa809c038f3', '335027803269365760', '芙蓉王', 28.0000, '0002', 'CLOSE', 6, '1996-04-03 10:36:53', '2007-05-21 15:27:53');
INSERT INTO `order_uncompleted_order0` VALUES ('e67bfbccad6e49ada4a883329712c4a4', 'da996f7ebb0b4789b823952c5dc282e5', '335027804338913280', '红塔山', 15.0000, '0003', 'UN_KNOW', 0, '2000-04-24 16:00:53', '2010-09-24 10:48:53');
INSERT INTO `order_uncompleted_order0` VALUES ('e7a7543cc86b4c1fb95b9616682de894', '7a530933dd4a49709c966061ed25fbb8', '335027803558772736', '黄鹤楼', 3.0000, '1001', 'CLOSE', 9, '2001-01-02 19:00:53', '2010-01-17 03:46:53');
INSERT INTO `order_uncompleted_order0` VALUES ('ea0e206961764fa19f98c5e93ba02140', '6f4e3b6a1a284c74b33949b38ef95f1f', '335027802598277120', '黄鹤楼', 8.0000, '1001', 'CLOSE', 9, '1999-12-02 16:08:53', '2007-12-02 17:39:53');
INSERT INTO `order_uncompleted_order0` VALUES ('ea232af8846c40a8b8f0dd7930994fab', 'b2c588d70cdb4d66aafa9ae8c5c4841b', '335027663410298880', '小熊猫', 0.0000, '1001', 'UN_KNOW', 6, '1987-08-16 12:15:19', '2000-07-05 01:57:19');
INSERT INTO `order_uncompleted_order0` VALUES ('eba13548ebad40ffa2de3c3e21e7c50f', '86d78e8c182946b08aa7d5cb75560def', '335027662701461504', '利群', 16.0000, '0001', 'STOP', 9, '1983-05-26 07:23:19', '2000-08-21 04:03:19');
INSERT INTO `order_uncompleted_order0` VALUES ('ebc68880c2e743b3bcce73a9084aea55', '77b2dc6811b74f8ca424acc7ca800769', '335027661896155136', '红塔山', 28.0000, '1001', 'DELAY', 1, '2002-08-09 17:02:19', '2014-11-12 02:58:19');
INSERT INTO `order_uncompleted_order0` VALUES ('ed93c5b107194b6d8fdace1deca87480', 'b33aabb05af44411a65c6d46584ec564', '335027801855885312', '芙蓉王', 2.0000, '0003', 'CLOSE', 4, '1985-10-09 00:36:52', '2001-03-19 12:47:52');
INSERT INTO `order_uncompleted_order0` VALUES ('f0d4b7cc1994422c92c5f8edc8f864cc', '8493afd7a5b24992b2a9435a9453c300', '335027661820657664', '红塔山', 20.0000, '0003', 'OPEN', 3, '1998-06-23 21:25:19', '2010-10-21 08:30:19');
INSERT INTO `order_uncompleted_order0` VALUES ('f2ece1e6b4934909a175c2401884c7b0', 'e870553d90054f33a867a388338913ea', '335027662613381120', '红塔山', 5.0000, '0002', 'UN_KNOW', 5, '2013-01-13 06:02:19', '2019-04-09 03:25:19');
INSERT INTO `order_uncompleted_order0` VALUES ('f4703912cde84a158b2a386657d2e0b4', '02f3bbd3cf3f431d8c63ba3b04d4e82c', '335027662143619072', '黄鹤楼', 26.0000, '0001', 'STOP', 9, '1986-04-09 12:46:19', '2004-04-27 06:38:19');
INSERT INTO `order_uncompleted_order0` VALUES ('f48ca84b0e944ace8fb9372ee33a195e', '290b21b1520443fb8aad9785dc958ef3', '335027662487552000', '黄鹤楼', 8.0000, '0001', 'UN_KNOW', 9, '2003-08-13 08:30:19', '2019-02-28 21:05:19');
INSERT INTO `order_uncompleted_order0` VALUES ('f4f5b72569c043b3bc10073eba935d37', 'f40bbf6033bd46d0847e32af599ceb66', '335027804317941760', '芙蓉王', 21.0000, '1001', 'OPEN', 3, '1985-04-27 02:10:53', '2001-09-30 10:25:53');
INSERT INTO `order_uncompleted_order0` VALUES ('f6d24b78389440f8b8156ca653664968', 'a6d2d7fc0fc4472dab667e9f97678853', '335027660281348096', '芙蓉王', 25.0000, '1001', 'STOP', 5, '2006-12-16 10:40:19', '2013-02-05 00:29:19');
INSERT INTO `order_uncompleted_order0` VALUES ('f9302c50906a47129ab18ebcd9c26e4a', 'b97215c915e0435490fe61f8e34870f7', '335027662001012736', '雪茄', 21.0000, '0002', 'STOP', 5, '2014-02-04 11:53:19', '2015-06-16 16:28:19');
INSERT INTO `order_uncompleted_order0` VALUES ('fa08772cd83d42a6bc72688f05b1b3ab', 'a030d4836df645978308dba0d098dabc', '335027663330607104', '小熊猫', 12.0000, '1001', 'STOP', 3, '1997-01-14 09:03:19', '2005-06-20 08:03:19');
INSERT INTO `order_uncompleted_order0` VALUES ('fa0e29c2072748c7a67ef9192dc026c7', 'ce787b058faa477e9934edc13e811431', '335027662365917184', '黄鹤楼', 1.0000, '1001', 'UN_KNOW', 7, '1995-01-03 13:22:19', '2003-03-28 02:56:19');
INSERT INTO `order_uncompleted_order0` VALUES ('fa888bde045a4bf2a4ba6a0aa5d47e01', '695c909b28524374892c65cfbb094909', '335027802141097984', '黄鹤楼', 18.0000, '0001', 'STOP', 0, '1990-12-29 00:26:53', '2005-05-22 20:13:53');
INSERT INTO `order_uncompleted_order0` VALUES ('fad66004dfa54259984df58a0cd9e15a', 'e28ce5de783449ef88548cfed6161105', '335027803462303744', '雪茄', 28.0000, '0002', 'UN_KNOW', 8, '2009-03-16 20:59:53', '2015-05-28 08:42:53');
INSERT INTO `order_uncompleted_order0` VALUES ('fc6cf8978b114f19b237b38a2daf5a57', '92646dc8d24a46ab83367b5c6370a96a', '335027662110064640', '芙蓉王', 9.0000, '1001', 'OPEN', 4, '1998-03-28 14:05:19', '2005-04-08 11:18:19');
INSERT INTO `order_uncompleted_order0` VALUES ('fe3c14dd516c4a33a89517ab4f3871f1', 'ededef6d6f074fa1b1b1a25dd455c9a9', '335027663120891904', '红塔山', 17.0000, '0003', 'UN_KNOW', 0, '1998-02-24 02:34:19', '2003-08-24 12:44:19');

-- ----------------------------
-- Table structure for order_uncompleted_order1
-- ----------------------------
DROP TABLE IF EXISTS `order_uncompleted_order1`;
CREATE TABLE `order_uncompleted_order1`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `order_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `amount` decimal(10, 4) NULL DEFAULT NULL COMMENT '价格',
  `pay_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付状态',
  `order_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `payment_times` int(11) NULL DEFAULT NULL COMMENT '支付次数',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_uncompleted_order1
-- ----------------------------
INSERT INTO `order_uncompleted_order1` VALUES ('006d6b98ba7541f19309ecff429b369b', '31449494d13442368e506db0505c3a14', '335027661963264001', '长白山', 14.0000, '1001', 'UN_KNOW', 4, '2003-08-01 23:06:19', '2018-08-14 15:27:19');
INSERT INTO `order_uncompleted_order1` VALUES ('00859e695c7f43939cb62d75efbfdd1c', 'd20f3bf41c3446a1b4fac9c96a8145a8', '335027801629392897', '小熊猫', 4.0000, '0003', 'CLOSE', 7, '1994-11-23 16:55:52', '2009-12-01 15:35:52');
INSERT INTO `order_uncompleted_order1` VALUES ('00a3928543084771b25cca750eb882d6', 'a742a8cd626a466fb4e0c2932b84427e', '335027803957231617', '长白山', 13.0000, '0001', 'DELAY', 1, '2002-05-21 07:55:53', '2012-08-03 10:20:53');
INSERT INTO `order_uncompleted_order1` VALUES ('02b5f7f3c1124cc58c319e2d88000069', '904aa370582a44538bb0ae25643ee13d', '335027663397715969', '利群', 0.0000, '0001', 'CLOSE', 3, '1987-08-28 02:26:19', '2003-12-23 12:44:19');
INSERT INTO `order_uncompleted_order1` VALUES ('02ca256c2e9f4b6bbb4b66cfc590b133', '96338b82325f47498dbae0558010d76d', '335027663540322305', '芙蓉王', 1.0000, '0001', 'CLOSE', 5, '1983-12-02 00:07:20', '2002-04-03 16:12:20');
INSERT INTO `order_uncompleted_order1` VALUES ('04a38d065211449bb0b01744816d4c76', 'ac6f713dd2a94aaf8ef9974850ca41a9', '335027803445526529', '长白山', 5.0000, '0001', 'OPEN', 1, '1997-02-05 10:54:53', '2005-12-02 00:59:53');
INSERT INTO `order_uncompleted_order1` VALUES ('082f17c171bc42c9b04931605aa0b354', '088ad07338794977836ad850405cdb37', '335027804326330369', '芙蓉王', 4.0000, '0002', 'DELAY', 1, '2009-03-01 23:47:53', '2010-12-22 20:50:53');
INSERT INTO `order_uncompleted_order1` VALUES ('0b510785929a4b04bb7abc0cfde2fc68', '1fd242f0b0aa46ffac54207918b5bdc5', '335027804255027201', '长白山', 12.0000, '0001', 'STOP', 4, '2016-05-22 23:56:53', '2016-06-21 19:20:53');
INSERT INTO `order_uncompleted_order1` VALUES ('0c66683bf14947b29c4a47a8b7170e05', '18cec2b06e0f447b89b36751b4c250d7', '335027663284469761', '小熊猫', 13.0000, '0002', 'CLOSE', 6, '2014-04-24 14:33:19', '2014-06-15 14:16:19');
INSERT INTO `order_uncompleted_order1` VALUES ('0e605189c6a4425989404f97bc55a6ba', '252f1a78d90d41478044802bce1752b5', '335027803869151233', '雪茄', 16.0000, '0003', 'STOP', 7, '2003-02-28 20:54:53', '2008-04-22 21:47:53');
INSERT INTO `order_uncompleted_order1` VALUES ('0e6afbc292ed4d4c9b08f9cd24e80d76', 'bf5fb644d5094dbeb2d2184315eda12d', '335027662567243777', '红塔山', 10.0000, '0003', 'UN_KNOW', 6, '2011-07-12 04:57:19', '2013-05-27 03:45:19');
INSERT INTO `order_uncompleted_order1` VALUES ('103fb490be494a01bceba4369f210827', '4cbcf5ba5e7747d58b0acddbb2e51143', '335027804561211393', '芙蓉王', 9.0000, '0001', 'DELAY', 9, '2004-11-13 05:43:53', '2010-02-08 16:52:53');
INSERT INTO `order_uncompleted_order1` VALUES ('10644c57af4c43478dc57fcb325f63c5', '776eebeda29c4d9abc30efc1a3b0f0d0', '335027662810513409', '小熊猫', 8.0000, '1001', 'STOP', 4, '2000-11-06 08:00:19', '2015-11-24 21:57:19');
INSERT INTO `order_uncompleted_order1` VALUES ('125a6af7f0914ceb84ef105674003e6f', 'ade07ca670bc430d8dfeec0b49076455', '335027661313146881', '小熊猫', 6.0000, '0001', 'DELAY', 2, '1998-11-23 23:50:19', '2011-09-14 04:08:19');
INSERT INTO `order_uncompleted_order1` VALUES ('130cfe6a3c0845c69d39a1a041ddbf4f', '01f25de611bd4952b3e3681d9e1eee50', '335027663427076097', '黄鹤楼', 2.0000, '0003', 'STOP', 2, '1993-01-16 14:48:19', '2008-12-14 12:54:19');
INSERT INTO `order_uncompleted_order1` VALUES ('139de528d2e54bfa9efa74e4f4d9c8de', '1a9ee1f4a95e41628bf437a42dfc38be', '335027803323891713', '利群', 1.0000, '0003', 'STOP', 6, '2005-09-12 05:47:53', '2015-05-13 23:37:53');
INSERT INTO `order_uncompleted_order1` VALUES ('160c0cec3fd84bd18af355b5cdb80c7d', 'ecebb8d1701840eb9a0c1eb1d102b2ea', '335027662428831745', '利群', 13.0000, '0003', 'CLOSE', 0, '1994-07-25 10:35:19', '2011-11-08 12:15:19');
INSERT INTO `order_uncompleted_order1` VALUES ('1b84d0d4fcb747b38c3a1fd4d256ca33', 'ac13de4888cb44b6802319f4fb63103c', '335027662781153281', '芙蓉王', 20.0000, '0001', 'UN_KNOW', 0, '2006-10-05 16:52:19', '2006-11-05 18:23:19');
INSERT INTO `order_uncompleted_order1` VALUES ('1c717b076b804d59b2cef09ef1c95e4c', 'aa79c4c6d2ab4b79ac2733766d1647c0', '335027803386806273', '小熊猫', 22.0000, '0002', 'OPEN', 9, '1984-10-26 00:49:53', '2001-11-04 01:02:53');
INSERT INTO `order_uncompleted_order1` VALUES ('1da2e796c8fb4051883d95a266fc3afd', '6e3ef5d616cf44059f6bae280dd9504a', '335027663452241921', '红塔山', 25.0000, '0002', 'DELAY', 5, '2009-02-20 00:23:19', '2013-01-22 19:14:19');
INSERT INTO `order_uncompleted_order1` VALUES ('1e3a511cba204bacb88d95a2a883297b', '37d4a382061643e49dc9d03c2d78a188', '335027803621687297', '利群', 27.0000, '0001', 'DELAY', 9, '1994-03-23 13:37:53', '2009-05-17 12:37:53');
INSERT INTO `order_uncompleted_order1` VALUES ('2272e9d06dc241d2bd04f12d2b05ad51', 'f24d520a86d9440a93cdd93a622bbdac', '335027802677968897', '黄鹤楼', 22.0000, '0001', 'STOP', 1, '1998-09-19 01:28:53', '2000-12-17 11:20:53');
INSERT INTO `order_uncompleted_order1` VALUES ('22f03dcaf7fd46fd9759f73bf9306212', '72f3d85d921b4e96a5099e70de14773a', '335027803353251841', '雪茄', 11.0000, '0002', 'STOP', 1, '1984-11-15 10:13:53', '2000-05-31 14:26:53');
INSERT INTO `order_uncompleted_order1` VALUES ('23ca4a7fd70d4f3db4185458d5056e20', '3e20e6de94ae49c8a7545b57a1ea9751', '335027663162834945', '黄鹤楼', 19.0000, '0001', 'DELAY', 3, '2003-10-15 18:58:19', '2003-11-04 07:12:19');
INSERT INTO `order_uncompleted_order1` VALUES ('2404fe337b4f40479d1eb9d1caa77225', '8ad8ed6455144cd5aaf3a19257e79389', '335027663368355841', '长白山', 17.0000, '0003', 'OPEN', 4, '2003-03-23 22:49:19', '2014-11-04 06:43:19');
INSERT INTO `order_uncompleted_order1` VALUES ('24836fbe7bd447fe8f45bfb2f42aa6a4', '04fb54cd5dd44c079a3a0531de5dfaa8', '335027663343190017', '芙蓉王', 10.0000, '1001', 'CLOSE', 9, '1991-02-09 02:16:19', '2007-10-29 02:31:19');
INSERT INTO `order_uncompleted_order1` VALUES ('2866f95505744550a3638a871b6abd9d', '698fbacbdab74194b2b6d7e8df12cd7d', '335027663137669121', '芙蓉王', 0.0000, '1001', 'OPEN', 2, '1990-04-10 13:54:19', '2009-03-25 22:55:19');
INSERT INTO `order_uncompleted_order1` VALUES ('2a0002e7914c41caa64e8234840b198e', '8c27cb4aca7d437f960035a97f0670e8', '335027803709767681', '芙蓉王', 20.0000, '1001', 'OPEN', 9, '2005-09-23 01:18:53', '2008-05-13 20:37:53');
INSERT INTO `order_uncompleted_order1` VALUES ('2aa782fabd6741b3a66c8d3343031580', 'd05242ca97a5463e8b5aed126131593c', '335027663188000769', '雪茄', 3.0000, '0002', 'OPEN', 9, '2013-02-12 15:01:19', '2016-12-13 20:22:19');
INSERT INTO `order_uncompleted_order1` VALUES ('2ac05e3aa26d4ac08ee5d63d4419fe1d', '4e475e44bfb044859301ddb1e2f67ab6', '335027662126841857', '芙蓉王', 21.0000, '0003', 'OPEN', 7, '1988-03-01 08:34:19', '2006-05-16 09:50:19');
INSERT INTO `order_uncompleted_order1` VALUES ('2cd526d7186c421b9ecf0f625c7c66f6', '2b0197ba6bcf42c7bbf587131518c6ed', '335027802887684097', '红塔山', 18.0000, '0001', 'OPEN', 6, '1990-09-11 17:52:53', '2004-06-26 04:22:53');
INSERT INTO `order_uncompleted_order1` VALUES ('305186ca860346e492c5528938ce5efd', 'c5cc46acade941c48d536b2a1efc4e24', '335027661556416513', '黄鹤楼', 9.0000, '0003', 'STOP', 5, '1994-02-15 19:42:19', '2009-03-08 05:44:19');
INSERT INTO `order_uncompleted_order1` VALUES ('3449320aa5774de182405305c948c5e9', 'bd9467b88dc14144ad19702941662163', '335027661506084865', '黄鹤楼', 3.0000, '1001', 'CLOSE', 8, '1986-09-05 22:58:19', '2004-01-21 05:40:19');
INSERT INTO `order_uncompleted_order1` VALUES ('35d18c75db8d42f79654550056a9fc45', '50af971b060e43bfa48b8b72106032af', '335027662684684289', '小熊猫', 10.0000, '0001', 'STOP', 4, '2008-08-20 15:19:19', '2013-06-30 10:09:19');
INSERT INTO `order_uncompleted_order1` VALUES ('363c258f564f4ca293c3610c70564dc0', 'b3fd55b395ad4045afeb1fda176f8e61', '335027801188990977', '芙蓉王', 18.0000, '0002', 'OPEN', 9, '1990-01-11 22:12:52', '2005-04-24 19:54:52');
INSERT INTO `order_uncompleted_order1` VALUES ('3aac3fcb8a6e4d808c47c928642908bd', '14be43d995174b5990cd97b9d51f82fb', '335027663229943809', '芙蓉王', 12.0000, '0003', 'CLOSE', 1, '1988-05-25 17:00:19', '2004-05-03 19:25:19');
INSERT INTO `order_uncompleted_order1` VALUES ('3bea0c1080a5413da476e5f94082249b', '3c77d005774746c1ab6db4fee101b6f1', '335027660008718337', '长白山', 3.0000, '0002', 'CLOSE', 6, '1999-05-07 14:59:19', '2005-04-01 08:01:19');
INSERT INTO `order_uncompleted_order1` VALUES ('3cd0ab2aff7245dc9950bf78f12241d3', '910053cebb284f539e9a7ea333c02da8', '335027803525218305', '黄鹤楼', 1.0000, '0001', 'UN_KNOW', 3, '2004-07-22 07:16:53', '2004-07-31 18:47:53');
INSERT INTO `order_uncompleted_order1` VALUES ('3fb0293cc3884d8cb180a0c14a4a0cd1', 'fbca5632fc91443084d09a15f3a6e3c1', '335027660558172161', '芙蓉王', 19.0000, '1001', 'UN_KNOW', 6, '1998-12-11 19:59:19', '2013-03-01 04:59:19');
INSERT INTO `order_uncompleted_order1` VALUES ('3fbf28c4e8244ce597e9d66495941b3e', 'bb199dc2cf9c4846a879e1d5b5d7f34e', '335027802623442945', '芙蓉王', 12.0000, '0002', 'STOP', 3, '1999-12-04 22:55:53', '2004-03-20 03:03:53');
INSERT INTO `order_uncompleted_order1` VALUES ('429483936a7a4970b0f8d7c160a85bd8', 'f3d2b602c40b468287458e0ae9e037da', '335027804489908225', '红塔山', 18.0000, '0003', 'STOP', 1, '2012-05-18 05:04:53', '2016-03-02 04:31:53');
INSERT INTO `order_uncompleted_order1` VALUES ('4439454186c34185a261c726b3026546', '046251ceaa6a4391a5de13ce4dc7b164', '335027662458191873', '长白山', 7.0000, '0002', 'UN_KNOW', 7, '2015-05-13 09:43:19', '2016-11-11 20:57:19');
INSERT INTO `order_uncompleted_order1` VALUES ('46736b5d0b5d43f3bfe1e4d9fc9269ed', 'cfbe56fa1221412e8be9a5671f8de240', '335027802317258753', '红塔山', 12.0000, '0002', 'STOP', 0, '2004-10-24 19:53:53', '2007-09-28 04:43:53');
INSERT INTO `order_uncompleted_order1` VALUES ('48f7b880db7a493b85099e11077f79d8', '26f4aa6e8afe4b4dad239d3a91cb0e49', '335027803198062593', '红塔山', 12.0000, '1001', 'OPEN', 5, '2005-02-10 00:51:53', '2005-05-24 06:28:53');
INSERT INTO `order_uncompleted_order1` VALUES ('4989ee6574494e5b88fad8c465ddad39', 'e3e74b24e6b74be3902b99c14a37a2e7', '335027662017789953', '小熊猫', 8.0000, '0001', 'CLOSE', 6, '1998-01-28 07:45:19', '2013-11-29 05:35:19');
INSERT INTO `order_uncompleted_order1` VALUES ('4b133cb15b33483ead782d0b36d0a6f9', '157b55b2407845b4a85f1af6269a52d6', '335027663255109633', '芙蓉王', 19.0000, '0001', 'UN_KNOW', 8, '1996-06-09 02:07:19', '2000-11-14 23:21:19');
INSERT INTO `order_uncompleted_order1` VALUES ('4d3eb27204af4de082eb057b46a8f2a7', '2e22b8ace8d94c2d8719efd437750a30', '335027804468936705', '黄鹤楼', 9.0000, '0002', 'DELAY', 9, '1998-11-28 13:24:53', '2015-04-13 17:42:53');
INSERT INTO `order_uncompleted_order1` VALUES ('504acacb1d6d4034b8f979a4b0bb1b70', 'de576a5feace4b3babe62630353b07a7', '335027803839791105', '雪茄', 5.0000, '0001', 'STOP', 7, '2006-11-09 05:43:53', '2010-03-09 16:41:53');
INSERT INTO `order_uncompleted_order1` VALUES ('521c50e62c1447f0958f3a7ebd3e482d', 'fe24124361244186a252f6cb39b1dc4d', '335027663477407745', '长白山', 0.0000, '0003', 'DELAY', 7, '2008-12-28 04:43:19', '2016-09-04 17:31:19');
INSERT INTO `order_uncompleted_order1` VALUES ('53004462ef2c4323b82b25613a72427f', '94343c2e1351442186770f0b87c65896', '335027661854212097', '雪茄', 23.0000, '0002', 'OPEN', 9, '2001-10-26 15:48:19', '2013-08-15 21:09:19');
INSERT INTO `order_uncompleted_order1` VALUES ('53dcc30386cf43388b021faf5b2ea4cf', '00a5b6fdd7bf4ee6a21bfa9b23863612', '335027802107543553', '利群', 25.0000, '0001', 'STOP', 8, '2003-10-17 19:06:53', '2009-09-04 03:18:53');
INSERT INTO `order_uncompleted_order1` VALUES ('56e7e5b92f8d4352b6b1be1ff59ee97c', '5c744101e3d843ff9132334bc3dff422', '335027662051344385', '利群', 16.0000, '1001', 'UN_KNOW', 4, '2006-10-06 09:45:19', '2012-03-21 07:49:19');
INSERT INTO `order_uncompleted_order1` VALUES ('5892a0b85e524a8ca5ffa3116e03749e', 'c9271076134040c6a4883e3dcf5afb17', '335027804615737345', '黄鹤楼', 5.0000, '0002', 'DELAY', 4, '2009-10-07 22:24:53', '2018-01-24 01:17:53');
INSERT INTO `order_uncompleted_order1` VALUES ('5cbc25b2e5e64ad48476db1e607bc62a', '51504d689efa429aa5e3c7806405a8be', '335027662546272257', '利群', 20.0000, '0001', 'STOP', 1, '1995-08-19 07:31:19', '2014-01-25 22:44:19');
INSERT INTO `order_uncompleted_order1` VALUES ('5d2f0a6ba9ba40c29eca54c848f6fae2', '51b996c8d10f42869491e382b6246bc5', '335027804645097473', '利群', 19.0000, '1001', 'OPEN', 0, '2013-02-28 06:01:53', '2015-11-25 09:14:53');
INSERT INTO `order_uncompleted_order1` VALUES ('5dc0b48c69e44f5e8b3cd6f6f26493ba', 'e868525fd71d4add889609d3afecf361', '335027659123720193', '黄鹤楼', 18.0000, '0001', 'DELAY', 1, '1993-06-11 22:55:18', '2005-12-14 06:43:18');
INSERT INTO `order_uncompleted_order1` VALUES ('5ff9adb2a17f4dca960ba2120c55ab76', '773cf079c86448ea89f9dbefbd1df3fa', '335027803600715777', '芙蓉王', 24.0000, '0002', 'DELAY', 1, '2002-07-09 07:36:53', '2016-03-19 20:21:53');
INSERT INTO `order_uncompleted_order1` VALUES ('6203cf39e49747b2af6bbe04a311c208', '58c0d7a9aebc44a1afc4960a2224f6a4', '335027662378500097', '利群', 26.0000, '0003', 'UN_KNOW', 5, '2011-09-08 18:51:19', '2014-12-19 07:50:19');
INSERT INTO `order_uncompleted_order1` VALUES ('62b31abb223a4c838311c520f6ba35d9', '0db0fdaa07aa4fba896436b0a5a37a73', '335027661392838657', '利群', 9.0000, '0003', 'STOP', 4, '2001-04-21 05:40:19', '2018-08-24 15:53:19');
INSERT INTO `order_uncompleted_order1` VALUES ('65a4df9ced9b428d8b9855b6c083ca2c', '3bb76dfd7be142d7a2010ee41c8b5b26', '335027662625964033', '小熊猫', 25.0000, '0002', 'DELAY', 6, '1994-05-31 18:05:19', '2012-03-13 06:23:19');
INSERT INTO `order_uncompleted_order1` VALUES ('664055869ad349c0ba53a48eeb553924', '188bcc8f5d194ed59d528573a477b5bb', '335027661262815233', '雪茄', 10.0000, '1001', 'DELAY', 8, '1997-08-19 13:07:19', '2008-08-20 05:52:19');
INSERT INTO `order_uncompleted_order1` VALUES ('66763b2896084d8295dfa304e3acbbdd', '22c1af29b14d45faaf03294007b61b64', '335027804510879745', '红塔山', 27.0000, '1001', 'OPEN', 7, '1988-08-23 16:20:53', '2001-05-25 19:38:53');
INSERT INTO `order_uncompleted_order1` VALUES ('693985a3b56542a1927d15e30579d550', 'c82962a9e2f34bbeaa626a01cc7649fd', '335027663208972289', '黄鹤楼', 16.0000, '1001', 'DELAY', 9, '1990-05-19 21:37:19', '2001-09-13 15:35:19');
INSERT INTO `order_uncompleted_order1` VALUES ('6b87cb5ec22049129c114f9923c94db2', 'e759c75880ac4c4983581246fd8dc2ba', '335027801264488449', '长白山', 17.0000, '0002', 'STOP', 6, '2005-10-19 07:40:52', '2012-12-28 23:54:52');
INSERT INTO `order_uncompleted_order1` VALUES ('6cc8df0bf2a44fa3a1ff5f52914b487f', 'cb123069dde84210be709aed2d33621f', '335027661694828545', '芙蓉王', 6.0000, '0001', 'CLOSE', 7, '1999-04-29 15:27:19', '2014-03-31 03:17:19');
INSERT INTO `order_uncompleted_order1` VALUES ('7001764993194322a68496b1ba77bbc3', '5de74a90c05842769c53bf3c66114467', '335027662521106433', '芙蓉王', 21.0000, '1001', 'UN_KNOW', 7, '2005-05-03 18:21:19', '2011-06-27 03:51:19');
INSERT INTO `order_uncompleted_order1` VALUES ('72664a68fbab416a8059f65c5409b7c8', '449f5e8b296f42c49e77cafb36935562', '335027661111820289', '长白山', 4.0000, '0001', 'UN_KNOW', 4, '1990-09-25 15:24:19', '2000-06-26 21:36:19');
INSERT INTO `order_uncompleted_order1` VALUES ('747985d2f0794fb88ca7789c8843e0b2', 'ff7f3a564c8345b7ad3d7dd8f6722ba3', '335027803814625281', '雪茄', 2.0000, '0003', 'CLOSE', 5, '1994-06-07 22:33:53', '2012-01-29 12:12:53');
INSERT INTO `order_uncompleted_order1` VALUES ('77c717e4d2f24825beb6a8f19c0fdc6a', '070c438ce1794761b0d7779b065af623', '335027803642658817', '利群', 0.0000, '0001', 'UN_KNOW', 7, '1997-05-27 12:42:53', '2000-10-21 12:53:53');
INSERT INTO `order_uncompleted_order1` VALUES ('77f2fc7fb62a40d9821ea07497885524', '824693ca6e344bc599b700c121abe5a8', '335027662743404545', '利群', 19.0000, '0001', 'OPEN', 0, '2007-05-03 04:44:19', '2013-07-11 16:19:19');
INSERT INTO `order_uncompleted_order1` VALUES ('793455aaa01a45f3a14c1f7557f94266', '2a1fd0690d6f40c1ae6de215e54ca8c9', '335027803500052481', '利群', 1.0000, '0001', 'CLOSE', 8, '1997-05-24 14:19:53', '2013-04-08 03:04:53');
INSERT INTO `order_uncompleted_order1` VALUES ('7c222a30b5424b679e03e68474330329', '970c701bd12e4c859dbff4c8729bf007', '335027803290337281', '黄鹤楼', 14.0000, '1001', 'UN_KNOW', 2, '1995-06-22 06:09:53', '2007-07-02 16:22:53');
INSERT INTO `order_uncompleted_order1` VALUES ('7e99e3dce5894df29246c80822ee5b00', '08caa2bfbb104aaab95ec26d4addea3e', '335027802740883457', '芙蓉王', 24.0000, '1001', 'DELAY', 0, '1991-05-12 10:15:53', '2004-04-18 19:30:53');
INSERT INTO `order_uncompleted_order1` VALUES ('890db72b8b0c4fc38a81b123aa4929aa', 'a34f13ab865a40f1ad10d9084209e96a', '335027801449037825', '小熊猫', 10.0000, '0003', 'CLOSE', 6, '2004-02-08 02:15:52', '2018-12-30 18:15:52');
INSERT INTO `order_uncompleted_order1` VALUES ('8aa0e8a12a024d109088f8697acbf4a6', '395779261c9f4aa4a815ab613e9eb66f', '335027803550384129', '长白山', 1.0000, '0003', 'CLOSE', 4, '1988-08-13 04:29:53', '2000-07-30 09:57:53');
INSERT INTO `order_uncompleted_order1` VALUES ('8bcd81173da34f419fec2c3fdeb40bf0', '3d8b52df248f49d8ae379464fac1a0e0', '335027661829046273', '利群', 11.0000, '1001', 'DELAY', 3, '2003-07-31 12:30:19', '2014-06-07 07:25:19');
INSERT INTO `order_uncompleted_order1` VALUES ('93461a1612ff4c1999c792bb119ee2fe', 'e60d7d51a4074a4597278b9c93b997a2', '335027661988429825', '黄鹤楼', 18.0000, '0001', 'DELAY', 8, '1999-07-15 01:43:19', '2018-03-06 14:11:19');
INSERT INTO `order_uncompleted_order1` VALUES ('938094c447634a3b91ed74dbdee909b7', '13253b4f7f2c45a0933e2daf3e16ad8c', '335027662093287425', '小熊猫', 2.0000, '0001', 'DELAY', 6, '2003-11-21 21:28:19', '2008-03-08 02:57:19');
INSERT INTO `order_uncompleted_order1` VALUES ('943bfdb6b48d4e798e51033a61fc66c0', '294600e952814b0f992e07fd8bbe08be', '335027661652885505', '黄鹤楼', 9.0000, '0003', 'DELAY', 2, '1991-06-09 01:13:19', '2006-10-21 08:42:19');
INSERT INTO `order_uncompleted_order1` VALUES ('965c5426f07043da9eb2dff9a6811ead', '7e81b3f84b404dae9f36dee6717cdc40', '335027661623525377', '利群', 19.0000, '0003', 'DELAY', 9, '1989-10-10 03:50:19', '2002-03-16 09:18:19');
INSERT INTO `order_uncompleted_order1` VALUES ('98b089c53bf146919444f13fd7cc4a29', 'a057848f2b704d7a8b08528090329689', '335027662655324161', '红塔山', 8.0000, '0003', 'DELAY', 0, '2001-11-04 12:36:19', '2011-03-15 13:19:19');
INSERT INTO `order_uncompleted_order1` VALUES ('9a0987bd0b5f4616a29ec115c8bfe277', '22aa237a69fa4e52af83d10c13a0e227', '335027661204094977', '红塔山', 22.0000, '1001', 'UN_KNOW', 4, '2014-11-28 20:46:19', '2017-10-22 06:23:19');
INSERT INTO `order_uncompleted_order1` VALUES ('9a11dec85be1452eacf230a3e3460219', '3578bf70443c48ee811f2f9d15c28cce', '335027804380856321', '利群', 7.0000, '1001', 'CLOSE', 3, '1989-04-15 20:03:53', '2005-12-15 05:45:53');
INSERT INTO `order_uncompleted_order1` VALUES ('9aa9750eb29a481db7f6c81d5e7f51d6', 'c39cee685596453cbea377b7d10bf906', '335027803764293633', '长白山', 10.0000, '0002', 'UN_KNOW', 3, '1999-02-08 07:53:53', '2007-11-22 10:04:53');
INSERT INTO `order_uncompleted_order1` VALUES ('9d9bf4ebee6b4684b51a39f457b19ddd', '2f70e9fc63294b7b8c9e62d0b7218826', '335027801566478337', '利群', 10.0000, '0002', 'OPEN', 0, '1987-06-30 09:58:52', '2006-02-04 00:19:52');
INSERT INTO `order_uncompleted_order1` VALUES ('9e15fac77de343eb94c64dacca0a8369', '2d4354589cdb49389bf345c1d7508a90', '335027804737372161', '雪茄', 29.0000, '0003', 'OPEN', 4, '2006-08-25 17:40:53', '2015-09-05 07:38:53');
INSERT INTO `order_uncompleted_order1` VALUES ('9e21a0ab85d1408face6a8508ab2fd41', '45e5f7a2bacb4eff91e693ad38962055', '335027662500134913', '红塔山', 26.0000, '0001', 'CLOSE', 4, '1998-12-22 20:52:19', '2011-06-15 06:52:19');
INSERT INTO `order_uncompleted_order1` VALUES ('a293990d23e7425aacb40766c3f850d2', '6bd51a443cc44f0980ad47f6ddbac4f6', '335027662353334273', '芙蓉王', 11.0000, '1001', 'STOP', 5, '1997-01-10 12:28:19', '2005-09-26 00:57:19');
INSERT INTO `order_uncompleted_order1` VALUES ('a4dea6001d1e444bb3bfedbe177b7c26', 'cd8f467c3058460aabb4a6c548faa99d', '335027661808074753', '利群', 14.0000, '0003', 'UN_KNOW', 2, '2001-07-09 13:46:19', '2005-05-30 21:04:19');
INSERT INTO `order_uncompleted_order1` VALUES ('a787c0c61ce3490b85f0f194e54a2ca6', 'ba190524a5634e0e94f304a8268da18e', '335027662886010881', '长白山', 19.0000, '0001', 'STOP', 3, '2016-02-03 22:11:19', '2016-04-04 10:27:19');
INSERT INTO `order_uncompleted_order1` VALUES ('a9d822648b2449e6aa3913a730f3cac9', 'afb1bc4c70e94489b133b33951c8cd9b', '335027803252588545', '小熊猫', 23.0000, '0001', 'UN_KNOW', 7, '1993-04-25 19:53:53', '2011-06-08 00:55:53');
INSERT INTO `order_uncompleted_order1` VALUES ('aa045a925f9141b499a2bf50179114da', 'acfdb33d50b7409a835cf65159c40065', '335027804305358849', '红塔山', 19.0000, '0002', 'OPEN', 5, '2012-08-01 14:07:53', '2014-06-15 19:51:53');
INSERT INTO `order_uncompleted_order1` VALUES ('ab20da5debe54ff0be060635e7398d0d', 'bb0df0e6c6b74eeabed04de493e0afa0', '335027803919482881', '小熊猫', 10.0000, '0001', 'UN_KNOW', 6, '2005-11-04 05:01:53', '2016-10-14 05:05:53');
INSERT INTO `order_uncompleted_order1` VALUES ('ad6e2091dec34e1c86f1cc9c4895c4bf', '7d27dcbb325e4278ba7066923a73183b', '335027804678651905', '芙蓉王', 17.0000, '1001', 'OPEN', 2, '1991-03-28 05:19:53', '2006-08-28 21:04:53');
INSERT INTO `order_uncompleted_order1` VALUES ('b09271760ee04b029f1f5d0c5b06a1f1', 'c85280fe96e249319d743eb0c6601909', '335027661908738049', '小熊猫', 24.0000, '0002', 'DELAY', 7, '1994-11-18 10:50:19', '2000-10-29 11:55:19');
INSERT INTO `order_uncompleted_order1` VALUES ('b359cdef74d948fbb9bd586597139bcc', 'bbcdb92ca1cc4d89b03c6b3ac975b05e', '335027662323974145', '红塔山', 28.0000, '1001', 'OPEN', 1, '2009-05-23 22:32:19', '2015-08-30 17:04:19');
INSERT INTO `order_uncompleted_order1` VALUES ('b523a27c88a1410b84d756c4ac26a4f0', '48cb85be1fe14bbf9f365727b2c1b496', '335027661933903873', '红塔山', 1.0000, '1001', 'UN_KNOW', 2, '1999-04-12 09:33:19', '2001-11-07 10:12:19');
INSERT INTO `order_uncompleted_order1` VALUES ('b668928ad1f240e3b565240257d11280', 'fc2a247d95da4265bed3db260395f9b6', '335027662407860225', '黄鹤楼', 9.0000, '0001', 'DELAY', 7, '1987-08-16 12:25:19', '2005-09-18 23:29:19');
INSERT INTO `order_uncompleted_order1` VALUES ('b85941e52e10455486e55eeb587ecd39', '7fe16da4b3a44413a5307bf1df9fcafc', '335027802963181569', '雪茄', 26.0000, '0002', 'OPEN', 6, '1997-05-04 22:59:53', '2004-02-08 13:37:53');
INSERT INTO `order_uncompleted_order1` VALUES ('ba9d4c7b9ecb4e249693dd2256d38dfd', 'c0c2681e98ae4229936a3b6b247ddea2', '335027802849935361', '利群', 11.0000, '0003', 'OPEN', 8, '1997-07-08 10:41:53', '2007-09-04 05:59:53');
INSERT INTO `order_uncompleted_order1` VALUES ('badd3f078b2e4c97b3139d42ee2c514a', '4bee21902c2a4e2a94924481268b80e6', '335027804536045569', '雪茄', 0.0000, '0001', 'CLOSE', 1, '2000-02-20 03:26:53', '2005-08-29 05:56:53');
INSERT INTO `order_uncompleted_order1` VALUES ('bb1766bf63f24aaba17f0d22ec45221f', '65d86473917545c59624beee562ff104', '335027803575549953', '雪茄', 0.0000, '0001', 'UN_KNOW', 7, '1992-11-22 07:21:53', '2008-05-02 15:50:53');
INSERT INTO `order_uncompleted_order1` VALUES ('bce424f7049c44d286f30a589a1eac28', '93c0c7f3151d4058b4cf57467ed51e26', '335027663506767873', '芙蓉王', 19.0000, '1001', 'CLOSE', 3, '2004-05-30 19:05:19', '2011-08-15 17:55:19');
INSERT INTO `order_uncompleted_order1` VALUES ('bfb841fa307345de8c74a59e68a31384', 'e7ee6931b7294423aec5c7e66e608b93', '335027662160396289', '小熊猫', 13.0000, '0003', 'UN_KNOW', 6, '2004-11-10 21:29:19', '2010-12-24 01:31:19');
INSERT INTO `order_uncompleted_order1` VALUES ('c72d4ad6490c4f589bf1351fa3776bd2', '0a0936e118f54efeaee2eab17f183be6', '335027801918799873', '长白山', 28.0000, '0003', 'CLOSE', 0, '1993-06-23 07:51:52', '2007-02-12 14:06:52');
INSERT INTO `order_uncompleted_order1` VALUES ('ca6ede54fca54955b6bcc7d957a4d014', '5f24ef12c5da40c5adcb2694b00afe1a', '335027801830719489', '长白山', 23.0000, '0002', 'UN_KNOW', 5, '1996-02-23 07:12:52', '2002-01-24 06:24:52');
INSERT INTO `order_uncompleted_order1` VALUES ('cb2451da078e4c7cb4039bbcd1e73eb5', '27c88856a8bd4d6f872fa72a5fd41ab1', '335027803688796161', '长白山', 4.0000, '0002', 'STOP', 0, '2001-02-15 09:28:53', '2014-07-06 19:29:53');
INSERT INTO `order_uncompleted_order1` VALUES ('cbdc05e046524273b3acd4e947aee5aa', 'eeadfad094174801b9c844a1ba057c08', '335027804414410753', '芙蓉王', 3.0000, '0002', 'UN_KNOW', 8, '2002-12-28 21:44:53', '2015-02-17 11:36:53');
INSERT INTO `order_uncompleted_order1` VALUES ('d22a6ded9bda487e99cc56cb21623a99', 'b556edfaf56e475d97f5b5a7af7b14cc', '335027800777949185', '黄鹤楼', 25.0000, '0001', 'CLOSE', 6, '2015-06-04 05:44:52', '2016-04-07 21:07:52');
INSERT INTO `order_uncompleted_order1` VALUES ('d77373b7294e469095dab8c9a804f865', '0eea90b914dc49fb9074845ba08013af', '335027662714044417', '雪茄', 2.0000, '0002', 'DELAY', 0, '2013-02-15 01:11:19', '2013-04-11 03:56:19');
INSERT INTO `order_uncompleted_order1` VALUES ('da256adc85124a2d8a583953a181f942', 'cf9c31f6ef8847bc853c633b8fa1182b', '335027803101593601', '芙蓉王', 15.0000, '1001', 'OPEN', 4, '1991-10-31 05:46:53', '2009-12-26 02:11:53');
INSERT INTO `order_uncompleted_order1` VALUES ('dd7c7bf645df4ebfa199165d4df8e334', 'f2e0b8c68f3b4773997d09ab67b7cb9e', '335027803139342337', '长白山', 0.0000, '0002', 'DELAY', 9, '1994-09-10 01:57:53', '2007-11-06 14:53:53');
INSERT INTO `order_uncompleted_order1` VALUES ('e1447478948a448b89b7d522659bec4f', '2dd7472b633b484a8e041d67bd03aefe', '335027804351496193', '小熊猫', 26.0000, '0002', 'CLOSE', 6, '2014-11-13 03:16:53', '2018-03-14 23:40:53');
INSERT INTO `order_uncompleted_order1` VALUES ('e4f1eef975ee4b42a2a705d103e61465', '01cf091746044bf8a4126bacd328bb1d', '335027804284387329', '利群', 27.0000, '0003', 'OPEN', 3, '2006-03-12 01:49:53', '2017-08-31 05:29:53');
INSERT INTO `order_uncompleted_order1` VALUES ('e6fa5e449a624255b323a0d744185bbb', 'cb95690080e949aab341b7dc3110ef53', '335027803734933505', '雪茄', 5.0000, '0002', 'DELAY', 5, '1997-01-07 19:03:53', '2005-09-21 03:29:53');
INSERT INTO `order_uncompleted_order1` VALUES ('e8579d3f57ae4b50b480bd0af23ba7bc', 'ede625b10fc341cc902e5a3cb3592b56', '335027801738444801', '长白山', 13.0000, '0001', 'OPEN', 2, '2000-09-16 07:19:52', '2013-01-26 17:41:52');
INSERT INTO `order_uncompleted_order1` VALUES ('ec3f20f18d5c477593d862b4c0e27bc4', 'bec0272763bb48489f7094a3121bab12', '335027662592409601', '雪茄', 14.0000, '1001', 'CLOSE', 1, '1995-10-13 13:55:19', '2006-05-10 12:52:19');
INSERT INTO `order_uncompleted_order1` VALUES ('efe4a81018524932a5ace5c86d760c77', 'd537fee6778f486483c59de74881fc1f', '335027661883572225', '利群', 23.0000, '0002', 'DELAY', 9, '2005-01-15 12:50:19', '2017-04-08 01:01:19');
INSERT INTO `order_uncompleted_order1` VALUES ('f024c111ab3341ef85d5a8a03acb39c1', '282cecd35d594e288e3ab550fb17beab', '335027803789459457', '芙蓉王', 24.0000, '0002', 'OPEN', 9, '1994-03-13 14:07:53', '2002-01-19 13:37:53');
INSERT INTO `order_uncompleted_order1` VALUES ('f0f78c7828764250af3640307d9ef46b', 'e326e2c622d5431e9d8efbe2c35a7d5e', '335027661724188673', '芙蓉王', 0.0000, '0002', 'OPEN', 9, '1990-08-18 21:09:19', '2005-09-30 22:51:19');
INSERT INTO `order_uncompleted_order1` VALUES ('f1c095ab6c464287a78cbb6521236157', 'aa81d06a010749e8a612b5d6ef01d5c7', '335027661778714625', '利群', 6.0000, '1001', 'STOP', 5, '1995-08-22 23:53:19', '2011-11-21 14:35:19');
INSERT INTO `order_uncompleted_order1` VALUES ('f28502af9d6b422aaf3b7cdaa87dafc4', 'b23dbfd68a134569ad33f6f7cc6f1e7f', '335027663318024193', '长白山', 4.0000, '0002', 'UN_KNOW', 0, '2015-06-14 16:16:19', '2016-03-08 10:52:19');
INSERT INTO `order_uncompleted_order1` VALUES ('f4b753abc5b64e23a19dbce8b1ecfc39', '791129c273f246159ca613710faf8760', '335027804443770881', '利群', 17.0000, '0002', 'OPEN', 1, '2012-12-05 05:12:53', '2017-10-29 17:29:53');
INSERT INTO `order_uncompleted_order1` VALUES ('f5dfd4d4aae048c286e177a9870fc96a', '91df38a292bf4d61add8dec9a657407d', '335027802581499905', '小熊猫', 14.0000, '1001', 'STOP', 2, '2002-10-04 10:09:53', '2014-05-27 02:35:53');
INSERT INTO `order_uncompleted_order1` VALUES ('f7c7cb81563e4009b57457170389c5b7', 'f9fa0083ae224ce0afcdf6b6c19a73b8', '335027661753548801', '红塔山', 10.0000, '1001', 'STOP', 7, '2010-11-19 10:59:19', '2016-12-11 18:55:19');
INSERT INTO `order_uncompleted_order1` VALUES ('f811d1385b8f4efdbad354d3a6e33201', 'f08830187c48452fb4d155b1a7811277', '335027662479163393', '小熊猫', 11.0000, '0001', 'OPEN', 2, '2005-11-02 00:17:19', '2010-11-10 23:05:19');
INSERT INTO `order_uncompleted_order1` VALUES ('f91372564c3c4c97a643fee9b2abb5a3', 'c1096ef2eab44a1dab37984e488cc027', '335027803479080961', '利群', 15.0000, '0001', 'CLOSE', 8, '1992-03-26 07:50:53', '2005-07-26 11:29:53');
INSERT INTO `order_uncompleted_order1` VALUES ('f919eb88974340c893aa6111da763e95', '2142382b93d4463185790498904ebd2d', '335027802787020801', '黄鹤楼', 28.0000, '0001', 'DELAY', 7, '1997-02-18 08:28:53', '2016-02-20 20:48:53');
INSERT INTO `order_uncompleted_order1` VALUES ('fd2bddc54a7447b8bcfff1137e8455c3', '4415240534a04f51b3985a41c9201e5e', '335027804590571521', '长白山', 18.0000, '1001', 'DELAY', 3, '2000-09-30 21:07:53', '2003-08-01 06:45:53');
INSERT INTO `order_uncompleted_order1` VALUES ('fef41fa81e75411580421da0d4aea269', '320daca39e2e41d8a9c4dd329d9eabda', '335027803667824641', '长白山', 2.0000, '0002', 'STOP', 3, '1996-10-25 17:29:53', '2000-06-11 04:32:53');

SET FOREIGN_KEY_CHECKS = 1;
