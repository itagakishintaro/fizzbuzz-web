# language: ja
フィーチャ:fizzbuzz

  シナリオテンプレート:3の倍数
    もし <call>が３の倍数
    ならば answerはfizzであるべき

  例:
    | call |
    | "3"  |
    | "３" |
    | "6"  |

  シナリオテンプレート:5の倍数
    もし <call>が５の倍数
    ならば answerはbuzzであるべき

  例:
    | call |
    | "5"  |
    | "５" |
    | "10" |

  シナリオテンプレート:3の倍数かつ5の倍数
    もし <call>が３の倍数かつ５の倍数
    ならば answerはfizzbuzzであるべき

  例:
    | call |
    | "15" |
    |"１５"|
    | "30" |

  シナリオテンプレート:3の倍数でも5の倍数でもない
    もし <call>が3の倍数でも5の倍数でもない
    ならば answerは<call>であるべき

  例:
    | call |
    | "a"  |
    | "1"  |
