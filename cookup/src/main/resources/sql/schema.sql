drop database if exists cookup;
create database cookup;
use cookup;

/*
--用户表
用户id	user_id
邮箱	email
手机号	phone
密码	password
昵称	username
住址	address
*/
create table user(
  user_id int auto_increment comment '用户id',
  email varchar(50) unique comment '邮箱',
  phone varchar(20) unique comment '手机号',
  password varchar(20) comment '密码',
  username varchar(11) comment '昵称',
  address varchar(255) comment '住址',
  primary key(user_id)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='用户表';

/*--食谱表
食谱id	recipe_id
所属用户id	user_id
食名	recipe_name
图片url	pic_url
材料	material
一句话简介	profile*/
create table recipe(
  recipe_id int auto_increment comment '食谱id',
  user_id int  comment '所属用户id',
  recipe_name varchar(20) comment '食名',
  pic_url varchar(255) comment '图片url',
  material varchar(255) comment '材料',
  profile varchar(255) comment '一句话简介',
  primary key(recipe_id)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='食谱表';

/*
--工序食谱对应表
工序id	step_id
食谱id	recipe_id
第几步	step_index
详细步骤内容	step_content*/
create table step(
  step_id int auto_increment comment '工序id',
  recipe_id int comment '食谱id',
  step_index int comment '第几步',
  step_content varchar(255) comment '详细步骤内容',
  primary key(step_id)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='工序食谱对应表';

/*--标签表
标签id	label_id
标签所属类别（菜系，菜品，口味，厨具，工艺，其他）	label_mark
标签名	label_name
标签查询次数	search_times*/
create table label(
  label_id int auto_increment comment '标签id',
  label_mark varchar(10) comment '标签所属类别',
  label_name varchar(10) comment '标签名',
  search_times int default 0 comment '标签查询次数',
  primary key(label_id)
)engine=InnoDB auto_increment=1 default charset=utf8 comment='标签表';
insert into label(label_mark,label_name)
values('菜系','川菜'),
  ('菜系','湘菜'),
  ('菜系','粤菜'),
  ('菜系','闽菜'),
  ('菜系','浙菜'),
  ('菜系','鲁菜'),
  ('菜系','苏菜'),
  ('菜系','徽菜'),
  ('菜系','京菜'),
  ('菜系','天津菜'),
  ('菜系','上海菜'),
  ('菜系','渝菜'),
  ('菜系','东北菜'),
  ('菜系','清真菜'),
  ('菜系','晋菜'),
  ('菜系','赣菜'),
  ('菜系','湖北菜'),
  ('菜系','云南菜'),
  ('菜系','贵州菜'),
  ('菜系','新疆菜'),
  ('菜系','淮扬菜'),
  ('菜系','潮州菜'),
  ('菜系','客家菜'),
  ('菜系','广西菜'),
  ('菜系','西北菜'),
  ('菜系','香港美食'),
  ('菜系','台湾菜'),
  ('菜系','澳门美食'),
  ('菜系','西餐'),
  ('菜系','日本料理'),
  ('菜系','韩国料理'),
  ('菜系','泰国菜'),
  ('菜系','越南菜'),
  ('菜系','意大利菜'),
  ('菜系','墨西哥菜'),
  ('菜系','西班牙菜'),
  ('菜系','法国菜'),
  ('菜系','美国菜'),
  ('菜系','巴西烧烤'),
  ('菜系','东南亚菜'),
  ('菜系','印度菜'),
  ('菜系','伊朗菜'),
  ('菜系','土耳其菜'),
  ('菜系','澳大利亚菜'),
  ('菜品','酸'),
  ('菜品','甜'),
  ('菜品','苦'),
  ('菜品','辣'),
  ('菜品','咸'),
  ('菜品','爽口'),
  ('菜品','清淡'),
  ('菜品','酸甜'),
  ('菜品','咸甜'),
  ('菜品','香甜'),
  ('菜品','微辣'),
  ('菜品','中辣'),
  ('菜品','超辣'),
  ('菜品','麻辣'),
  ('菜品','酸辣'),
  ('菜品','鲜辣'),
  ('菜品','香辣'),
  ('菜品','咸鲜'),
  ('菜品','椒盐'),
  ('菜品','咸香'),
  ('菜品','原味'),
  ('菜品','奶香'),
  ('菜品','葱香'),
  ('菜品','韭香'),
  ('菜品','蒜香'),
  ('菜品','酱香'),
  ('菜品','糟香'),
  ('菜品','五香'),
  ('菜品','蚝香'),
  ('菜品','鱼香'),
  ('菜品','果味'),
  ('菜品','草莓味'),
  ('菜品','香草味'),
  ('菜品','薄荷味'),
  ('菜品','橘子味'),
  ('菜品','番茄味'),
  ('菜品','柠檬味'),
  ('菜品','苹果味'),
  ('菜品','蓝莓味'),
  ('菜品','咖喱味'),
  ('菜品','孜然味'),
  ('菜品','芥末味'),
  ('菜品','黑椒味'),
  ('菜品','姜汁味'),
  ('菜品','茄汁味'),
  ('菜品','烧烤味'),
  ('菜品','红油味'),
  ('菜品','蛋黄味'),
  ('菜品','蟹黄味'),
  ('菜品','糖醋味'),
  ('菜品','泡椒味'),
  ('菜品','怪味'),
  ('菜品','芝士味'),
  ('菜品','抹茶味'),
  ('菜品','芝麻味'),
  ('菜品','巧克力味'),
  ('菜品','糊辣'),
  ('菜品','芒果味'),
  ('菜品','西瓜味'),
  ('菜品','西柚味'),
  ('菜品','水蜜桃味'),
  ('口味','酸'),
  ('口味','甜'),
  ('口味','苦'),
  ('口味','辣'),
  ('口味','咸'),
  ('口味','爽口'),
  ('口味','清淡'),
  ('口味','酸甜'),
  ('口味','咸甜'),
  ('口味','香甜'),
  ('口味','微辣'),
  ('口味','中辣'),
  ('口味','超辣'),
  ('口味','麻辣'),
  ('口味','酸辣'),
  ('口味','鲜辣'),
  ('口味','香辣'),
  ('口味','咸鲜'),
  ('口味','椒盐'),
  ('口味','咸香'),
  ('口味','原味'),
  ('口味','奶香'),
  ('口味','葱香'),
  ('口味','韭香'),
  ('口味','蒜香'),
  ('口味','酱香'),
  ('口味','糟香'),
  ('口味','五香'),
  ('口味','蚝香'),
  ('口味','鱼香'),
  ('口味','果味'),
  ('口味','草莓味'),
  ('口味','香草味'),
  ('口味','薄荷味'),
  ('口味','橘子味'),
  ('口味','番茄味'),
  ('口味','柠檬味'),
  ('口味','苹果味'),
  ('口味','蓝莓味'),
  ('口味','咖喱味'),
  ('口味','孜然味'),
  ('口味','芥末味'),
  ('口味','黑椒味'),
  ('口味','姜汁味'),
  ('口味','茄汁味'),
  ('口味','烧烤味'),
  ('口味','红油味'),
  ('口味','蛋黄味'),
  ('口味','蟹黄味'),
  ('口味','糖醋味'),
  ('口味','泡椒味'),
  ('口味','怪味'),
  ('口味','芝士味'),
  ('口味','抹茶味'),
  ('口味','芝麻味'),
  ('口味','巧克力味'),
  ('口味','糊辣'),
  ('口味','芒果味'),
  ('口味','西瓜味'),
  ('口味','西柚味'),
  ('口味','水蜜桃味'),
  ('厨具','炒锅'),
  ('厨具','平底锅'),
  ('厨具','煎锅'),
  ('厨具','蒸锅'),
  ('厨具','汤锅'),
  ('厨具','奶锅'),
  ('厨具','砂锅'),
  ('厨具','炖锅'),
  ('厨具','电火锅'),
  ('厨具','塔吉锅'),
  ('厨具','高压锅'),
  ('厨具','电压力锅'),
  ('厨具','空气炸锅'),
  ('厨具','电饭煲'),
  ('厨具','炖盅'),
  ('厨具','烤箱'),
  ('厨具','冰箱'),
  ('厨具','微波炉'),
  ('厨具','烧烤炉'),
  ('厨具','多士炉'),
  ('厨具','电饼铛'),
  ('厨具','面包机'),
  ('厨具','面条机'),
  ('厨具','榨汁机'),
  ('厨具','料理机'),
  ('厨具','豆浆机'),
  ('厨具','酸奶机'),
  ('厨具','冰淇淋机'),
  ('厨具','咖啡机'),
  ('厨具','刨冰机'),
  ('厨具','厨师机'),
  ('厨具','爆米花机'),
  ('厨具','华夫饼机'),
  ('厨具','保鲜盒'),
  ('厨具','打蛋器'),
  ('厨具','模具'),
  ('工艺','炒'),
  ('工艺','爆'),
  ('工艺','蒸'),
  ('工艺','烩'),
  ('工艺','涮'),
  ('工艺','炖'),
  ('工艺','熬'),
  ('工艺','煨'),
  ('工艺','煎'),
  ('工艺','焖'),
  ('工艺','烧'),
  ('工艺','溜'),
  ('工艺','熏'),
  ('工艺','腌'),
  ('工艺','炸'),
  ('工艺','烤'),
  ('工艺','拌'),
  ('工艺','汆'),
  ('工艺','煮'),
  ('工艺','烹'),
  ('工艺','煸'),
  ('工艺','烫'),
  ('工艺','酿'),
  ('工艺','酱'),
  ('工艺','卤'),
  ('工艺','泡'),
  ('工艺','冻'),
  ('工艺','贴'),
  ('工艺','卷'),
  ('工艺','扒'),
  ('工艺','焗'),
  ('工艺','烙'),
  ('工艺','灼'),
  ('工艺','炝'),
  ('工艺','滚'),
  ('工艺','浸'),
  ('工艺','干煸'),
  ('工艺','干炒'),
  ('工艺','清炒'),
  ('工艺','滑炒'),
  ('工艺','爆炒'),
  ('工艺','酱爆'),
  ('工艺','葱爆'),
  ('工艺','干煎'),
  ('工艺','红焖'),
  ('工艺','黄焖'),
  ('工艺','葱焖'),
  ('工艺','红烧'),
  ('工艺','酱烧'),
  ('工艺','干烧'),
  ('工艺','葱烧'),
  ('工艺','醋溜'),
  ('工艺','滑溜'),
  ('工艺','铁板'),
  ('工艺','捞汁'),
  ('工艺','拔丝'),
  ('工艺','挂霜'),
  ('工艺','糖渍'),
  ('工艺','压榨'),
  ('工艺','微波'),
  ('工艺','焙'),
  ('工艺','烘'),
  ('工艺','扣'),
  ('工艺','拼'),
  ('工艺','淋'),
  ('工艺','醉'),
  ('工艺','塌');

/*
--标签食谱对应表
标签食谱id recipe_label_id
标签id	label_id
食谱id	recipe_id
标签名	label_name*/
create table recipe_label(
  recipe_label_id int auto_increment comment '标签食谱id',
  label_id int comment '标签id',
  recipe_id int comment '食谱id',
  primary key(recipe_label_id)
)engine=InnoDB auto_increment=1 default charset=utf8 comment='标签食谱对应表';

/*
--评论食谱对应表
评论id	comment_id
食谱id	recipe_id
评论用户id	user_id
评分数	score
评论内容 content*/
create table comment(
  comment_id int auto_increment comment '评论id',
  recipe_id int comment '食谱id',
  user_id int comment '评论用户id',
  score int comment '评分数',
  content varchar(255) comment '评论内容',
  primary key(comment_id)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='评论食谱对应表';

/*
--收藏表
收藏id  collection_id
用户id	user_id
食谱id	recipe_id*/
create table collection(
  collection_id int auto_increment comment '收藏id',
  user_id int comment '用户id',
  recipe_id int comment '食谱id',
  primary key(collection_id)
)engine=InnoDB auto_increment=1 default charset=utf8 comment='收藏表';