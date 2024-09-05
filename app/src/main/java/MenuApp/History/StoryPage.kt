package MenuApp.History

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.babycorner.BottomNavigationBar
import com.example.babycorner.R

data class Story(
    val id: Int,
    val title: String,
    val content: String,
    val imageResId: Int? = null
)

@Composable
fun StoryPage(navController: NavHostController, storyId: Int) {
    val stories = listOf(
        Story(
            id = 1,
            title = "Chapeuzinho Vermelho",
            content = "Era uma vez uma bela e ingênua menina chamada Chapeuzinho Vermelho. A garota vivia com sua mãe em uma pequena casa à beira da floresta. Chapeuzinho tinha um carinho especial por sua avó, que morava do outro lado da densa mata.\n" +
                    "\n" +
                    "Um belo dia, a mãe de Chapeuzinho pediu que ela levasse uma cesta com alimentos para sua avó, que estava doente. Mesmo sendo um caminho longo e cheio de perigos, Chapeuzinho se prontificou a ajudar sua avó querida.\n" +
                    "\n" +
                    "Logo no início da trilha, Chapeuzinho Vermelho foi abordada pelo astuto Lobo. Sem perceber a malícia, Chapeuzinho contou ao Lobo sobre sua missão de levar comida para a avó. O Lobo, esperto como era, sugeriu um caminho mais rápido para Chapeuzinho, enquanto ele mesmo seguia por um atalho ainda mais curto.\n" +
                    "\n" +
                    "Chegando à casa da avó, o Lobo bateu à porta e entrou, devorando a pobre senhora. Disfarçando-se como a avó, o Lobo esperou pela chegada de Chapeuzinho Vermelho.\n" +
                    "\n" +
                    "Quando Chapeuzinho chegou, notou que sua avó estava diferente, mas antes que pudesse reagir, o Lobo a engoliu também. Felizmente, um lenhador que passava por ali ouviu os gritos e conseguiu resgatar Chapeuzinho e sua avó, livrando-as do Lobo mau.\n" +
                    "\n" +
                    "E assim, Chapeuzinho Vermelho aprendeu a não confiar em estranhos e a sempre seguir os conselhos de sua mãe. \".\n" +
                    "\n" +
                    "Fim.",
            imageResId = R.drawable.chapeuzinho2
        ),
        Story(
            id = 2,
            title = "Os Três Porquinhos",
            content = "Era uma vez, Três porquinhos irmãos que viviam com a mamãe. Dois porquinhos não ajudavam em nada na casa, enquanto o terceiro porquinho sentia pena da quantidade de trabalho que a mamãe tinha e estava sempre disposto a ajudá-la.\n" +
                    "\n" +
                    "Num belo dia, a mamãe, acreditando da maturidade dos filhos, pediu que saíssem de casa para seguir suas próprias vidas. Ela fez preparou um saco com um saco com provisões para cada um deles e forneceu algumas economias para que comprassem material para construírem as casas.\n" +
                    "\n" +
                    "O primeiro porquinho, muito preguiçoso, quis construir uma casa que não desse trabalho. Apesar da advertência dos irmãos, construiu uma casa de palha.\n" +
                    "\n" +
                    "O segundo porquinho, um pouco menos preguiçoso que o primeiro, resolveu construir uma casa de madeira. Apesar de mais segura do que a casa de palha, a de madeira não era boa para o frio e não era resistente o suficiente para impedir a entrada de um lobo.\n" +
                    "\n" +
                    "O terceiro porquinho, por sua vez, precavido e paciente, resolveu construir sua casa com tijolos.\n" +
                    "\n" +
                    "Enquanto os dois irmãos mais novos terminaram as construções de palha e madeira em uma manhã, o terceiro porquinho seguiu engajado na sua demorada construção. Em três dias o trabalho estava feito: ergueu uma resistente casa com tijolos e cimento.\n" +
                    "\n" +
                    "Algum tempo depois, um lobo surgiu na floresta. Percebendo a presença dos porquinhos foi logo bater na primeira casa, a feita com palha. O primeiro porquinho, em pânico, fugiu para a casa ao lado, a do irmão que havia trabalhado com a madeira.\n" +
                    "\n" +
                    "O lobo dirigiu-se então para a segunda casa e, como os porquinhos não abriram a porta, ameaçou assoprar para destruir a construção. A casa de madeira, de fato, caiu com a rajada de vento. Aproveitando a falta de fôlego, os porquinhos correram para a casa do irmão mais velho.\n" +
                    "\n" +
                    "O irmão mais velho os abrigou e garantiu que tudo correria bem. Quando o lobo soprou novamente, a casa, feita de tijolos, sequer mexeu um milímetro. No dia seguinte, o lobo voltou a atacar a casa que restava, dessa vez tentou entrar pela lareira. Como o porquinho mais velho era muito precavido, deixou um caldeirão de sopa fervendo posicionado bem embaixo da lareira. O lobo, ao cair na caldeira, fugiu desesperado e os três porquinhos continuaram sãos e salvos.\".\n" +
                    "\n" +
                    "Fim.",
            imageResId = R.drawable.pig2
        ),
        Story(
            id = 3,
            title = "O Patinho Feio",
            content = "Era uma vez uma pata que escolheu cuidadosamente onde fazer o seu ninho. Afinal os colocou em um local protegido, perto do rio, com muitas folhagens. A pata foi chocando os ovos até aqueles começaram a se romper dando origem a patinhos amarelinhos muito belos.\n" +
                    "\n" +
                    "Apenas um ovo, maior, permaneceu intacto. Intrigada ela chocou ainda mais e depois acabou por ajudar a romper a casca com o bico. De lá saiu um filhote estranho, cinza, completamente diferente dos outros.\n" +
                    "\n" +
                    "Todos os que davam parabéns à pata - o peru, as galinhas, o porquinho - diziam que ela havia tido uma ninhada linda, exceto pelo patinho feio.\n" +
                    "\n" +
                    "\"Ele é grande e sem graça\", \"Tem um ar abobalhado\", acusavam aqueles que não sabiam lidar o pássaro diferente da ninhada.\n" +
                    "\n" +
                    "Os irmãos do patinho feio percebendo a situação passaram então a excluir aquele que era meio esquisito.\n" +
                    "\n" +
                    "Por fim a própria pata passou a sentir vergonha e a abandonar o filhote diferente.\n" +
                    "\n" +
                    "O abandono e o sofrimento\n" +
                    "E o patinho feio cresceu assim - sozinho e em sofrimento -, tendo que aturar as bicadas das galinhas e a perseguição de outros animais. Cansado de sofrer, um belo dia o patinho feio resolveu fugir.\n" +
                    "\n" +
                    "Primeiro encontrou um lago repleto de marrecos. Lá não ligaram para o patinho feio. Habituado ao sofrimento, pelo menos era melhor passar mais despercebido do que levar com a agressão dos outros animais. Mas a tranquilidade durou pouco, um dia caçadores chegaram e espantaram todos.\n" +
                    "\n" +
                    "Perdido novamente no mundo encontrou uma outra lagoa que serviu de abrigo. Lá viu pela primeira vez belos cisnes brancos e ficou instantaneamente admirado. Ainda errante, procurou mais alguns abrigos e sofreu por todos onde esteve.\n" +
                    "\n" +
                    "Enquanto isso o patinho foi se desenvolvendo e, ao encontrar um novo abrigo, ao lado dos cisnes, descobriu pelo reflexo da água que ele próprio era também uma daquelas criaturas que tanto admirava.\n" +
                    "\n" +
                    "Os cisnes do grupo imediatamente deram as boas vindas e o patinho, antes humilhado, passou a ter a companhia dos irmãos da mesma espécie ficando com o coração cheio de felicidade.\n" +
                    "\n" +
                    "Um belo dia uma criança estava passeando pelo lago quando, ao olhar para o antigo patinho feio, e disse admirado: \"olhem, pais, tão lindo esse cisne novo, é o mais bonito de todos!\".\n" +
                    "\n" +
                    "Fim.",
            imageResId = R.drawable.patinho2
        )
    )

    val story = stories.find { it.id == storyId } ?: return

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.height(16.dp))

                story.imageResId?.let { imageResId ->
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Text(
                    text = story.title,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = story.content,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Justify
                    ),
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
