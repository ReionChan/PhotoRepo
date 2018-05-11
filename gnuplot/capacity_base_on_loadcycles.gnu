set title "MacBook Pro（Retina，13 英寸，2013 年末）电池容量充电循环耗损表"
set key
set grid

set xlabel "充电循环次数"
set xrange [90:310]
set xtics 90,10,310
set xtics nomirror

set ylabel "电池容量（mAh）"
set yrange [4500:6500]
set ytics 4500,500,6500
set ytics nomirror

# set y2label "充电循环次数"
# set y2range [100:340]
# set y2tics 100,10,340

# plot "capacity_base_on_loadcycles.dat" using 3:2 with lp pt 7 ps 1 lc 2 title "电池容量", "capacity_base_on_loadcycles.dat" using 3:1 axis x1y2 with lp pt 43 ps 1 lc 1 title "充电循环"

plot "capacity_base_on_loadcycles.dat" using 1:2 with lp pt -1 lw 3 lc 2 title "电池容量"