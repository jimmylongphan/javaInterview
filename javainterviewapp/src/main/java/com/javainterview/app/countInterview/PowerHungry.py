def solution(panels):
    if len(panels) == 0:
        return str(0)

    if len(panels) == 1:
        return str(panels[0])

    if len(panels) == 2:
        return str(max(panels[0] * panels[1]), max(panels))

    negative_panels = []
    positive_panels = []

    for panel in panels:
        if panel < 0:
            negative_panels.append(panel)
        if panel > 0:
            positive_panels.append(panel)

    if len(negative_panels) == 1 and len(positive_panels) == 0:
        return str(0)

    if len(negative_panels) % 2 == 1:
        negative_panels.remove(max(negative_panels))
    
    product = 1
    for panel in negative_panels:
        product *= panel

    for panel in positive_panels:
        product *= panel

    return str(product)
