### conda install diagrams
from diagrams import Cluster, Diagram, Edge
from diagrams.custom import Custom
import os
os.environ['PATH'] += os.pathsep + 'C:/Program Files/Graphviz/bin/'

graphattr = {     #https://www.graphviz.org/doc/info/attrs.html
    'fontsize': '22',
}

nodeattr = {   
    'fontsize': '22',
    'bgcolor': 'lightyellow'
}

eventedgeattr = {
    'color': 'red',
    'style': 'dotted'
}
with Diagram('flip_flopArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctx_flip_flop', graph_attr=nodeattr):
          nor_1=Custom('nor_1','./qakicons/symActorSmall.png')
          nor_2=Custom('nor_2','./qakicons/symActorSmall.png')
          user=Custom('user','./qakicons/symActorSmall.png')
     nor_1 >> Edge(color='blue', style='solid',  decorate='true', label='<nor_1_out &nbsp; >',  fontcolor='blue') >> nor_2
     nor_2 >> Edge(color='blue', style='solid',  decorate='true', label='<nor_2_out &nbsp; >',  fontcolor='blue') >> nor_1
     user >> Edge(color='blue', style='solid',  decorate='true', label='<nor_2_in_2 &nbsp; >',  fontcolor='blue') >> nor_2
     user >> Edge(color='blue', style='solid',  decorate='true', label='<nor_1_in_1 &nbsp; >',  fontcolor='blue') >> nor_1
diag
