---
indent: true
geometry: margin=1in
fontsize: 12pt
header-includes: 
 - \usepackage{pgfplots}
 - \usepackage{pgfplotstable}
 - \usepackage{fancyhdr}
 - \usepackage{setspace}

 - \pagestyle{fancy}
 - \fancyhf{}
 - \fancyhead[R]{Campbell \thepage}
 - \renewcommand{\headrulewidth}{0pt}
 
 - \doublespacing

 - \pgfplotsset{compat=1.5}
---
\noindent Brigham Campbell

\noindent Dr. Griffith

\noindent CS 2235

\noindent 26 September 2019

\begin{center}
Programming Project 01
\end{center}

The following figure is the result of plotting the averages of the length of time six different sorting algorithms take to sort an array of variable length. The averages have been computed by running each sorting algorithm 50 times per array size.

\begin{center}
  \begin{tikzpicture}
    \begin{axis}[
      xlabel={Array Size(\# of elements)},
      ylabel={Average $\Delta$Time(seconds)},
      legend entries={Hybrid,Insertion,Merge,Quick,Selection,Tim},
      legend style={
        at={(0.02,0.98)},
        anchor=north west},
      width=4.5in,
      height=4.5in]
      \addplot table[x=arraySize, y expr=\thisrowno{0}*.000000001, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y expr=\thisrowno{1}*.000000001, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y expr=\thisrowno{2}*.000000001, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y expr=\thisrowno{3}*.000000001, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y expr=\thisrowno{4}*.000000001, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y expr=\thisrowno{5}*.000000001, col sep = comma] {timings.csv};
    \end{axis}
  \end{tikzpicture}
\end{center}

As the graph illustrates, MergeSort and TimSort take much more time than the other functions. Below is a graph excluding the two algorithms to better show how the other functions compare to each other.

\begin{center}
  \begin{tikzpicture}
    \begin{axis}[
      xlabel={Array Size(\# of elements)},
      ylabel={Average $\Delta$Time(seconds)},
      legend entries={Hybrid,Insertion,Quick,Selection},
      legend style={
        at={(0.02,0.98)},
        anchor=north west},
      width=4.5in,
      height=4.5in]
      \addplot table[x=arraySize, y expr=\thisrowno{0}*.000000001, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y expr=\thisrowno{1}*.000000001, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y expr=\thisrowno{3}*.000000001, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y expr=\thisrowno{4}*.000000001, col sep = comma] {timings.csv};
    \end{axis}
  \end{tikzpicture}
\end{center}

With these results, it's clear that HybridSort is by far the best sorting function among these implementations. This is strange because TimSort should be faster in theory. However, this makes sense because TimSort has been implemented recursively. In Java, function calls have significant overhead, so thousands of function calls will scale the time an algorithm takes to complete by a large factor.

Taking into account the results show here, I'd recommend HybridSort. However, I'd also consider that a non-recursive implementation of TimSort could be even faster than HybridSort as implemented here. 
