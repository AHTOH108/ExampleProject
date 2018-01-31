package com.novsu.antonivanov.exampleproject.WebView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.novsu.antonivanov.exampleproject.R;

import java.net.URL;

public class WebViewActivity extends AppCompatActivity {

    public static final String SERVER_URL_DEV = "http://access.inrecolan.com:5555"; // VLADIMIR

    private String html = "<p><a title=\\\"ТЛУМ!\\\" href=\\\"http://tlum.ru\\\" target=\\\"_blank\\\">Ссылка на Тлум</a></p> <p>Ниже опрос:</p> <p><!— TlumVote start —> <link rel=\\\"stylesheet\\\" href=\\\"//access.inrecolan.com:5555/assets/vote/style.min.css\\\"> <script type=\\\"text/javascript\\\"> (function (d, w, c, h) { (w[c] = w[c] || []).push({ id: '24', el: (function () { var a = d.getElementsByTagName('script'); return a[a.length - 1]; })(), host: h, endpoint: '', }); var s = d.createElement('script'); s.type = 'text/javascript'; s.async = true; s.src = h + '/assets/vote/script.min.js?_t=' + Date.now(); d.head.appendChild(s); })(document, window, 'TlumVote', '//access.inrecolan.com:5555'); </script> <!-- TlumVote end --> </p> ";
    private String urlTest = "http://access.inrecolan.com:5555/news/novost-dla-proverki-otobrazenia-na-mobilnom-kliente/";
    private String html_2 = "<head><link rel=\"stylesheet\" href=\"https://access.inrecolan.com:5555/assets/website/css/tlum-hd.css?t=20160427\"></head><p>Копия события с тлума:</p>\n" +
            "<p>Хорошие новости для родителей, которые выбирают правильные телеканалы для маленьких непосед! Уже совсем скоро, в&nbsp;мае этого года, состоится запуск канала Tlum HD, ориентированного на&nbsp;детскую аудиторию. Только новинки российской анимации и&nbsp;лучших образцов мировой мультипликации для ваших детей!</p>\n" +
            "<p>Подобранные для телеканала фильмы и&nbsp;мультфильмы ориентированы на&nbsp;российских телезрителей и&nbsp;станут хорошим подспорьем для родителей в&nbsp;воспитании детей. Мультфильмы&nbsp;— это не&nbsp;только развлечение. Разнообразные герои и&nbsp;занимательные сюжеты расширяют кругозор и&nbsp;знания ребенка. Персонажи любимых мультсериалов учат ребят быть добрыми, дружить и&nbsp;уважать друг друга, правильно справляться с&nbsp;различными ситуациями. Вместе с&nbsp;веселыми героями дети познают окружающий мир и&nbsp;учатся жить в&nbsp;гармонии с&nbsp;ним. Из&nbsp;мультфильмов можно узнать много нового и&nbsp;интересного, что, безусловно, пригодится детям в&nbsp;их&nbsp;личной жизни.</p>\n" +
            "<p>Распространяться «Тлум&nbsp;HD» будет через операторов в&nbsp;пакетах HD-каналов.</p>\n" +
            "<p>Не&nbsp;пропустите!</p>\n" +
            "<p><strong>Программа передач с 25.04 - 01.05</strong></p>\n" +
            "<table data-day=\"1\">\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td>6:00</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>6:30</td>\n" +
            "<td>Котики, вперед!</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>7:00</td>\n" +
            "<td>Ми-Ми-Мишки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:30</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:45</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:00</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:30</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:00</td>\n" +
            "<td>ПРЕМЬЕРА! Доктор Машинкова</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:30</td>\n" +
            "<td>Белка и Стрелка. Озорная семейка</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:00</td>\n" +
            "<td>Лунтик и его друзья</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:30</td>\n" +
            "<td>Маша и Медведь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>18:00</td>\n" +
            "<td>Тима и Тома</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>18:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:30</td>\n" +
            "<td>Фиксики</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:30</td>\n" +
            "<td>Барбоскины</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:00</td>\n" +
            "<td>Тима и Тома</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:20</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4:35</td>\n" +
            "<td>Фиксики</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table data-day=\"2\">\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td>6:00</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>6:30</td>\n" +
            "<td>ПРЕМЬЕРА! Доктор Машинкова</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>7:00</td>\n" +
            "<td>Белка и Стрелка. Озорная семейка</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:30</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:45</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:00</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:30</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:00</td>\n" +
            "<td>Лунтик и его друзья</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:30</td>\n" +
            "<td>Маша и Медведь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:00</td>\n" +
            "<td>Тима и Тома</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:30</td>\n" +
            "<td>Фиксики</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>18:00</td>\n" +
            "<td>Грузовичок Лева</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>18:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:30</td>\n" +
            "<td>Барбоскины</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:30</td>\n" +
            "<td>Ми-Ми-Мишки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:00</td>\n" +
            "<td>Грузовичок Лева</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4:30</td>\n" +
            "<td>Барбоскины</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table data-day=\"3\">\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td>6:00</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>6:30</td>\n" +
            "<td>Лунтик и его друзья</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>7:00</td>\n" +
            "<td>Маша и Медведь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:30</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:45</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:00</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:30</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:00</td>\n" +
            "<td>Тима и Тома</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:30</td>\n" +
            "<td>Фиксики</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:00</td>\n" +
            "<td>Грузовичок Лева</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:30</td>\n" +
            "<td>Барбоскины</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>18:00</td>\n" +
            "<td>Котики, вперед!</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>18:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:30</td>\n" +
            "<td>Ми-Ми-Мишки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:30</td>\n" +
            "<td>Белка и Стрелка. Озорная семейка</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:00</td>\n" +
            "<td>Котики, вперед!</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4:30</td>\n" +
            "<td>Ми-Ми-Мишки</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table data-day=\"4\">\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td>6:00</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>6:30</td>\n" +
            "<td>Тима и Тома</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>7:00</td>\n" +
            "<td>Фиксики</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:30</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:45</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:00</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:30</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:00</td>\n" +
            "<td>Грузовичок Лева</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:30</td>\n" +
            "<td>Барбоскины</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:00</td>\n" +
            "<td>Котики, вперед!</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:30</td>\n" +
            "<td>Ми-Ми-Мишки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>18:00</td>\n" +
            "<td>ПРЕМЬЕРА! Волшебники двора</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>18:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:30</td>\n" +
            "<td>Белка и Стрелка. Озорная семейка</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:30</td>\n" +
            "<td>Маша и Медведь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:00</td>\n" +
            "<td>ПРЕМЬЕРА! Доктор Машинкова</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4:30</td>\n" +
            "<td>Белка и Стрелка. Озорная семейка</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table data-day=\"5\">\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td>6:00</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>6:25</td>\n" +
            "<td>Грузовичок Лева</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>7:00</td>\n" +
            "<td>Барбоскины</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:30</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:45</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:00</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:30</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:00</td>\n" +
            "<td>Котики, вперед!</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:30</td>\n" +
            "<td>Ми-Ми-Мишки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:00</td>\n" +
            "<td>ПРЕМЬЕРА! Волшебники двора</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>15:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:30</td>\n" +
            "<td>Белка и Стрелка. Озорная семейка</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>18:00</td>\n" +
            "<td>Лунтик и его друзья</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>18:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:30</td>\n" +
            "<td>Маша и Медведь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:00</td>\n" +
            "<td>Новаторы</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:30</td>\n" +
            "<td>Фиксики</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:00</td>\n" +
            "<td>Лунтик и его друзья</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:30</td>\n" +
            "<td>ПРЕМЬЕРА! Пингвинёнок Пороро</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:00</td>\n" +
            "<td>Бумажки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:15</td>\n" +
            "<td>Волшебный фонарь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4:30</td>\n" +
            "<td>Маша и Медведь</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table data-day=\"6\">\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td>6:00</td>\n" +
            "<td>Грузовичок Лева</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>6:30</td>\n" +
            "<td>Котики, вперед!</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>7:00</td>\n" +
            "<td>ПРЕМЬЕРА! Доктор Машинкова</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>7:30</td>\n" +
            "<td>Тима и Тома</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:00</td>\n" +
            "<td>Лунтик и его друзья</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:30</td>\n" +
            "<td>ПРЕМЬЕРА! Приключения Тайо</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:00</td>\n" +
            "<td>Белка и Стрелка. Озорная семейка</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:30</td>\n" +
            "<td>Маша и Медведь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:00</td>\n" +
            "<td>Алиса знает, что делать!</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:15</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>17:30</td>\n" +
            "<td>Ми-Ми-Мишки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:00</td>\n" +
            "<td>МУЛЬТПремьера! Барбоскины, Тима и Тома, Ми-Ми-Мишки, Бумажки, Аркадий Паровозов спешит на помощь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:25</td>\n" +
            "<td>Барбоскины</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:30</td>\n" +
            "<td>Машины сказки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>21:40</td>\n" +
            "<td>Машкины страшилки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:00</td>\n" +
            "<td>Фиксики</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>23:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:00</td>\n" +
            "<td>Машины сказки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:05</td>\n" +
            "<td>Машкины страшилки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:25</td>\n" +
            "<td>ПРЕМЬЕРА! Буба</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:50</td>\n" +
            "<td>Алиса знает, что делать!</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table data-day=\"7\">\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td>6:00</td>\n" +
            "<td>ПРЕМЬЕРА! Приключения Тайо</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>8:30</td>\n" +
            "<td>Грузовичок Лева</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:00</td>\n" +
            "<td>Котики, вперед!</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>9:30</td>\n" +
            "<td>ПРЕМЬЕРА! Доктор Машинкова</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:00</td>\n" +
            "<td>Тима и Тома</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>10:30</td>\n" +
            "<td>Лунтик и его друзья</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>11:00</td>\n" +
            "<td>Барбоскины</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>12:30</td>\n" +
            "<td>Фиксики</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:00</td>\n" +
            "<td>ПРЕМЬЕРА! Барбадог</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>14:30</td>\n" +
            "<td>Ми-Ми-Мишки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>16:00</td>\n" +
            "<td>Машины сказки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>17:10</td>\n" +
            "<td>Машкины страшилки</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>17:30</td>\n" +
            "<td>Белка и Стрелка. Озорная семейка</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>19:00</td>\n" +
            "<td>Маша и Медведь</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>20:30</td>\n" +
            "<td>Защитники</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>22:20</td>\n" +
            "<td>Алиса знает, что делать!</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>0:30</td>\n" +
            "<td>Барбоскины</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2:00</td>\n" +
            "<td>Колобанга. Только для пользователей Интернета</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>3:30</td>\n" +
            "<td>Моланг</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<script type=\"text/javascript\">// <![CDATA[\n" +
            "!function(){FC={},FC.DOM={},FC.DOM.hasClass=function(e,t){return e.classList?e.classList.contains(t):!!e.className.match(new RegExp(\"(\\\\s|^)\"+t+\"(\\\\s|$)\"))},FC.DOM.addClass=function(e,t){e.classList?e.classList.add(t):hasClass(e,t)||(e.className+=\" \"+t)},FC.DOM.removeClass=function(e,t){if(e.classList)e.classList.remove(t);else if(hasClass(e,t)){var a=new RegExp(\"(\\\\s|^)\"+t+\"(\\\\s|$)\");e.className=e.className.replace(a,\" \")}},FC.DOM.show=function(e){e.style.display=\"block\"},FC.DOM.hide=function(e){e.style.display=\"none\"},FC.DOM.insertAfter=function(e,t,a){e.insertBefore(t,a.nextSibling)},FC.DOM.addEvent=function(e,t,a){e.addEventListener?e.addEventListener(t,a,!1):e.attachEvent?e.attachEvent(\"on\"+t,a):e[\"on\"+t]=a},FC.TlumHD=function(){this._boxElement=function(e){var t=document.createElement(\"div\");return t.setAttribute(\"class\",\"schedule-selector clear\"),t.innerHTML=e.days,t},this._itemTemplate=function(e){return'<a class=\"schedule-day js-schedule-day\" data-schedule-day=\"'+e.dayNumber+'\">'+e.dayName+\"</a>\"};var e=document.querySelectorAll(\"table[data-day]\");0!=e.length&&(this._allSchedules=Array.prototype.slice.call(e),this._init(),this._bindEvents())};var e=FC.TlumHD.prototype;e._init=function(){this._draw();var e=this.getCurrentDayNumber();this.selectDay(e),this.displaySchedule(e),this._allSchedules.forEach(function(e){FC.DOM.addClass(e,\"schedule-table\")})},e._draw=function(){var e=this._allSchedules[0],t=\"\",a=this;this._dayNames=[\"Пн\",\"Вт\",\"Ср\",\"Чт\",\"Пт\",\"Сб\",\"Вс\"],this._dayNames.forEach(function(e,s){var n=s+1,l=a._itemTemplate({dayName:e,dayNumber:n});t+=l});var s=a._boxElement({days:t});e.parentNode.insertBefore(s,e)},e.selectDay=function(e){var t=document.querySelector(\".js-schedule-day.selected\");t&&FC.DOM.removeClass(t,\"selected\");var a=this._getDayByNumber(e);FC.DOM.addClass(a,\"selected\")},e.displaySchedule=function(e){this._allSchedules.forEach(function(e){FC.DOM.hide(e)});var t=this._getScheduleByDayNumber(e);FC.DOM.show(t)},e._onClick=function(e){var t=e.getAttribute(\"data-schedule-day\");this.selectDay(t),this.displaySchedule(t)},e._getDayByNumber=function(e){var t='*[data-schedule-day=\"'+e+'\"]';return document.querySelector(t)},e._getScheduleByDayNumber=function(e){var t='*[data-day=\"'+e+'\"]';return document.querySelector(t)},e.getCurrentDayNumber=function(){var e=new Date;return e.getDay()},e._bindEvents=function(){var e=this,t=document.querySelectorAll(\".js-schedule-day\"),a=Array.prototype.slice.call(t);a.forEach(function(t){FC.DOM.addEvent(t,\"click\",function(){e._onClick(this)})})},new FC.TlumHD}();\n" +
            "// ]]></script>\n" +
            "<p>Конец таблички</p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView webViewContent = (WebView) findViewById(R.id.webViewContent);
        setupWebView(webViewContent);
    }

    private String getHtmlText() {
        //return getString(R.string.html_script_1);
        return html_2;
    }


    private void setupWebView(WebView webView) {


        //final WebSettings settings = webView.getSettings();
        //settings.setJavaScriptEnabled(true);
        //settings.setJavaScriptCanOpenWindowsAutomatically(true);
        //settings.setPluginState(WebSettings.PluginState.ON);

        //webView.getSettings().setJavaScriptEnabled(true);
        //webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        //webView.getSettings().setJavaScriptEnabled(true);
        //webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);

        //webView.setWebChromeClient(new WebChromeClient());
        String cssStyle = "<style>" +
                "img{display: inline;height: auto;max-width: 100%;}" +
                "iframe{height: auto;max-width: 99%;}" +
                "</style>";
        //webView.loadUrl(urlTest);
        webView.loadDataWithBaseURL(null, getHtmlText(), "text/html", "UTF-8", null);
    }

}
